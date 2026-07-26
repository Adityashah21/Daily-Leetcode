class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int lucky =-1;

        for(int num: arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for( int ket : map.keySet()){
            if(ket == map.get(ket)){
                if(ket>lucky){
                    lucky = ket;
                }
            }
        }

        return lucky;
    }
}