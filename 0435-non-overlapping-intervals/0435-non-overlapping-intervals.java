class Solution {
    class interval{
        int start;
        int end;
        interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        interval[] inter = new interval[n];
        int i=0;
        for(int[] arr : intervals){
            inter[i++]= new interval(arr[0], arr[1]);
        }
        Arrays.sort(inter,(a,b)->{
            if(a.end==b.end){
                return a.start-b.start;
            }
            return a.end-b.end;
        });

        int count=1;
        int lastend = inter[0].end;

        for(int j=1;j<n;j++){
            if(inter[j].start >= lastend){
                count++;
                lastend = inter[j].end;
            }
        }
        return n-count;
        
    }
}