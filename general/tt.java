
import java.util.*;
import java.io.*;
import java.util.stream.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class tt {

  //HashMap
  static void findMaxOccurance(String a) { 

    if ( (a == null) || a.length()==0 ) {
       return;
    }
    Map<Character, Integer>counts=new HashMap<>();
    int l=a.length();

    for(int i=0;i<l;i++) {
        char c=a.charAt(i);
        if (counts.containsKey(c)) {
            counts.put(c, counts.get(c)+1);
        } else {
            counts.put(c, 1);
        }
    }
    int result=0;
    char keyC=0;
    //look through Map.Entry : entrySet() keySet(), values(),  for Map.Entry : getKey(), getValue()
    for (Map.Entry<Character, Integer> e:counts.entrySet()) {
        if (e.getValue()>result) {
            result=e.getValue();
            keyC=e.getKey();
        }
    }

    System.out.println("key value : "+keyC + " "+result);
    
    /**
    for (Integer value : counts.values()) {
          result=(result>value)?result:value;
    }**/
    for (Character mykey:counts.keySet()) {
           if (counts.get(mykey) == result) {
               System.out.println("max key and value : "+mykey + " "+result);
           }
    }
  }
         //Stream filter
         public static List<String>  mysearch(List<String> myList) {

            return myList.stream().filter(a -> a.startsWith("a")).filter(a -> a.length()==3).collect(Collectors.toList());
        }

        //collect(Collectors.Collectors.joining(",");
        public static String getString(List<Integer>mylist){
         return mylist.stream().map(  e -> (e%2==0)?"e"+e:"o"+e).collect(Collectors.joining(","));
       
        }

        //stream distinct forEach without return anything
        public static void distincePrint1(List<Integer>mylist){
              mylist.stream().distinct().forEach(System.out::println); 
        }

        //count no using stream  distinct
        public static long distinceCount1(List<Integer>mylist){
              return mylist.stream().distinct().count(); 
        }

        //stream with comparator
        public static long getMax(List<Integer>myList) {

            return myList.stream().max(Comparator.naturalOrder()).get();
        }
        
        //Optional : isPresent
        public static double getAverage(List<Integer>myList) {

            OptionalDouble double1=myList.stream().mapToInt(x -> x).average();
            if (double1.isPresent()) {
                return double1.getAsDouble();
            }
            return 0;
        }

        //get min/max/average/sum/count from list
        public static double getSummaryStatisticsAverage(List<Integer>myList1) {

           return  myList1.stream().mapToInt( (x) -> x).summaryStatistics().getAverage();
        }
        public static long getSummaryStatisticsCount1(List<Integer>myList1) {
            return myList1.stream().mapToInt( (x) -> x).summaryStatistics().getCount();
        }
        public static long getSummaryStatisticsSum3(List<Integer>myList1) {

            return myList1.stream().mapToInt( (x) -> x).summaryStatistics().getSum();
        }

        public static long getSummaryStatisticsMin(List<Integer>myList1) {

            return myList1.stream().mapToInt( (x) -> x).summaryStatistics().getMin();
        }

        public static int getMax2(List<Integer>mylist) {

            return Collections.max(mylist);
        }

        //List to stream
        public static int getMax3(List<Integer>mylist) {
          return mylist.stream().max(Comparator.naturalOrder()).get();
        }

  public static void main(String[] args) {
      //ArrayList
      List<Integer>mylist=new ArrayList<>();    
      mylist.add(5);
      mylist.add(2);
      mylist.add(6);
      System.out.println(mylist.toString());

      //HashSet
      Set<Character>myset=new HashSet<>();
      myset.add('a');
      myset.add('b');

      Set<Integer>myorderedSet=new LinkedHashSet<>(mylist);
      myorderedSet.stream().distinct().collect(Collectors.toList());
      //HashMap
      Map<Integer, Integer>mycount=new HashMap<>();
      for (int i=0;i<mylist.size();i++) {
          Integer myKey=mylist.get(i);
          if (mycount.containsKey(myKey)) {
              mycount.put(myKey, mycount.get(myKey) + 1);
          } else {
              mycount.put(myKey, 1);
          }
      }
      Collectors.toList();
      System.out.println(Collections.max(mycount.values()));

      String[]aaa={" ", "dga", "agda", "", " "};

      Arrays.stream(aaa).toArray();
      System.out.println("filter : "+Arrays.toString(Arrays.stream(aaa).filter(e -> e.trim().length()!=0).toArray()));
      List<String>mylist22=Arrays.stream(aaa).filter(e -> e.trim().length() != 0).collect(Collectors.toList());
      for (String el: mylist22) {
          System.out.println("list element : "+el);
      }
      
      List<String>resultaa=new ArrayList<>();
      for (int i=0;i<aaa.length;i++) {
            if (aaa[i].trim().length() != 0) {
                resultaa.add(aaa[i]);
            }
      }
      String[] resulta=resultaa.toArray(new String[resultaa.size()]);
      System.out.println("list : "+resultaa.toString());
      System.out.println("resulta : " + Arrays.toString(resulta));
     
      Map<String, List<String>>mymap=new HashMap<>();
      List<String> mylist1=new ArrayList<>();
      mylist1.add("v1");
      mylist1.add("v2");
      mymap.put("key1", mylist1);

      List<String> mylist2=new ArrayList<>();
      mylist1.add("v3");
      mylist1.add("v4");
      mymap.put("key2", mylist2);





      //Arrays to Stream
      String[] lines={"1b ab", "2 dd", "5g ee", "3  gd", "2  tes", "1  ib"};
      final Map<String, Integer> myMap2 = Arrays.stream(lines).map(e -> e.trim().replaceAll("\\s+", "")).collect(Collectors.toMap(x -> x, x -> 1));
      System.out.println("map : " +myMap2.keySet() + myMap2.values());

      //StringBuilder
      StringBuilder build=new StringBuilder();
      build.append("abcd");
      build.replace(0, 2, "zz");
      build.delete(3,3);
      build.insert(1, "yy");
      build.deleteCharAt(0);
      System.out.println("modified characters : "+build);
      String myString=build.toString();
      myString.indexOf('y');
      myString.lastIndexOf("y");
      myString.charAt(0);
      myString=myString+"END";
      System.out.println("mystring : "+myString);

      //Arrays : 
      Integer[]a=new Integer[]{1, 2, 3};
      List<Integer>al=Arrays.asList(new Integer[]{1, 2, 3});
      Arrays.sort(a, Collections.reverseOrder());
      Arrays.binarySearch(a, 3);

      List<String>linkedlist1=new LinkedList<>();
      linkedlist1.add(0, "aa");
      linkedlist1.set(0, "bb");
      List<Integer>arraylist2=new ArrayList<>();
      boolean anym=arraylist2.stream().anyMatch(mm -> ( (mm % 2) == 0));
      
      StringJoiner j=new StringJoiner("-");
      j.add("test");
      j.add("test2");
      System.out.println(j.toString());
      String[]mystr=new String[10];
      Optional<String>myNullable=Optional.ofNullable(mystr[2]);
       String mytest=myNullable.of("test").orElse("Default");



       //String to Stream (Stream<Integer> Stream<Character>,  Stream<String>

     String mystring="abd";
     IntStream ints=mystring.chars();       
     IntStream ints2=mystring.codePoints();

     Stream<Character>cStream=ints.mapToObj(c -> (char) c);
     Stream<Character> cStream2=ints2.mapToObj(c -> (char)c);
     Stream<String> sSteam=mystring.chars().mapToObj(e -> String.valueOf((char)e));

     //Common usage patterns : 
     //1. Map values to stream and then get the max or count 
     HashMap<String, Integer>mymap2=new HashMap<>();
     mymap2.put("string1",2);
     mymap2.put("string2",1);
     mymap2.put("string3",3);
     System.out.println("map values to stream : reverse \n");
     System.out.println(mymap2.values().stream().max(Comparator.reverseOrder()).get());
     System.out.println("map values to stream : natural \n");
     System.out.println(mymap2.values().stream().max(Comparator.naturalOrder()).get());
     System.out.println(mymap2.values().stream().max(Integer::compare).get());
     System.out.println("map values to stream : count \n");
     System.out.println(mymap2.values().stream().count());

     List<Integer>myValues=mymap2.values().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
     System.out.println("map values to stream : value list \n");
     for (Integer all1: myValues) {
         System.out.println(all1);
     }
    //map filter by key or value or both to another map
    Map<String, Integer>resultm=mymap2.entrySet().stream().filter(e -> e.getKey().contains("Some Text")).filter(e->e.getValue().intValue()>0).collect(Collectors.toMap(m->m.getKey(), m->m.getValue()));
    //map key or values to string
    mymap2.entrySet().stream().filter(e->e.getKey().contains("sometthing")).collect(Collectors.toList());
   // mymap2.entrySet().stream().filter(e->e.getKey().contains("sometthing")).collect(Collectors.joining(","));
  }
    
}


