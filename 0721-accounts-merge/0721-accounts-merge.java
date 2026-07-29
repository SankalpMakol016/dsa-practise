class Solution {
    public class DSU {
    int[] parent,size;
    DSU(int n){
        this.parent = new int[n];
        this.size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find (int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }
    boolean union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(pu==pv)
            return false;

        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        return true;
    }
}

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        //email ->index
        HashMap<String,Integer> emailmap = new HashMap<>();
        for(int i=0;i<n;i++){
            List<String> account = accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email = account.get(j);

                if(!emailmap.containsKey(email)){
                    emailmap.put(email, i);
                }else{
                    dsu.union(i, emailmap.get(email));
                }
            }
        }

        HashMap<Integer,List<String>> merged = new HashMap<>();
        for(String email : emailmap.keySet()){
            int parent = dsu.find(emailmap.get(email));

            merged.putIfAbsent(parent,new ArrayList<>());
            merged.get(parent).add(email);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int parent : merged.keySet()){
            List<String> emails = merged.get(parent);
            Collections.sort(emails);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0));
            temp.addAll(emails);

            ans.add(temp);
        }
        return ans;
    }
}