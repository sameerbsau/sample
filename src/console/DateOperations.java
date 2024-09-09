//package console;
//
//public class DateOperations {
//
//    public static void main(String[] args) {
//        System.out.println("test");
//        System.out.println((100%100) == 0);
//    }
//
//    java.util.ArrayList list1 = (java.util.ArrayList)globalMap.get("list");
//System.out.println("final result aize "+list1.size());
//    JSONArray rawlist = (JSONArray)globalMap.get("rawlist");
//
//System.out.println("developerApps result aize "+rawlist.length());
//
////logic for split batch
//
//    int batchSize = (int)context.developer_file_size;
//    int readCount = 1;
//    int fileCounter = 0;
//    List shortList = new ArrayList();
//    Map finalBatch = new LinkedHashMap();
//System.out.println("batchSize----"+batchSize);
//for(int i = 0; i< rawlist.length(); i++){
//        if( readCount % batchSize ==0){
//            System.out.println("In if cond");
//            finalBatch.put("developerApps"+(fileCounter++), shortList);
//            shortList.clear();
//        }else{
//            System.out.println("In else cond");
//            shortList.add(rawlist.get(i));
//            readCount++;
//        }
//
//    }
//globalMap.put("developerApps", finalBatch);
//    List keyList = new ArrayList(finalBatch.keySet());
//globalMap.put("developerAppsSize", keyList.size());
//}
