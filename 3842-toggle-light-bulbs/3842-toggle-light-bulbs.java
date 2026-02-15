class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Integer> hm = new HashMap<>();//10: 2
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < bulbs.size(); i++){
            if(!hm.containsKey(bulbs.get(i))){
                hm.put(bulbs.get(i), 1);
                continue;
            }
            int val = hm.get(bulbs.get(i));
            val = val + 1;
            hm.put(bulbs.get(i), val);
        }
        for(Map.Entry<Integer, Integer> i : hm.entrySet()){
            // System.out.println("i.getValue: "+ i.getValue()+ "key: "+i.getKey());
            if(i.getValue() % 2 == 0){
                
                continue;
            }
            list.add(i.getKey());
        }
        Collections.sort(list);
        return list;
    }
}