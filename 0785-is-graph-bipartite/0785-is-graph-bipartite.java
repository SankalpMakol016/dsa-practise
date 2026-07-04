class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }

        for(int i=0;i<n;i++){
            if(color[i]!=-1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            color[i]=0;
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neigh : graph[curr]){
                    //not visited or colored
                    if(color[neigh]==-1){
                        if(color[curr]==0){
                            color[neigh]=1;
                            q.offer(neigh);
                        }else{
                            color[neigh]=0;
                            q.offer(neigh);
                        }
                    }
                    //already colored /visited
                    if(color[curr]==color[neigh]){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}