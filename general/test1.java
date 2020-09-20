import java.util.*;
import java.io.*;
import java.util.stream.*;

public class test1 {

  public static String twoStrings(String s1, String s2) {
      if (s1==null || s2 == null) {
          return "NO";
      }
      if (s1.length() == 1) {
          return s2.contains(s1)?"YES":"NO";
      }
      if (s2.length() ==1) {
          return s1.contains(s2)?"YES":"NO";
      }

      Set<String> ss1= new HashSet<String>(Arrays.asList(s1.trim().split("")));
      System.out.println("set ss1 : "+ ss1.toString());
      for (int i=0;i<s2.length();i++) {
          System.out.println("char : "+s2.charAt(i));
          if (ss1.contains(String.valueOf(s2.charAt(i)))) {
              return "YES";
          }
      }
      return "NO";
    }
    static List<Integer> removeDuplicates(ArrayList<Integer> a) {
        List<Integer>result=new ArrayList<>();

        if ( (a == null) || (a.size() == 0) || (a.size() == 1)) {
           return a;
        }
           
        for (int i=0;i<a.size();i++) {
            if (!result.contains(a.get(i))) {
                result.add(a.get(i));
            }
        }
        System.out.println(result.toString());
        return result;
    }
    static void removeDuplicates2(ArrayList<Integer> a) {

        if (a != null && (a.size() > 1)) {
        LinkedHashSet<Integer> nodup=new LinkedHashSet<Integer>(a);
        a.clear();
        a.addAll(nodup);
        }
        
    }

    static void reverseArrayList(ArrayList<Integer>a) {
           if ( (a != null ) && (a.size()>1)) {
           Stack<Integer> temp=new Stack<>();
           for (int i=0;i<a.size();i++) {
               temp.push(a.get(i));
           }
           a.clear();
           while (temp != null && !temp.isEmpty()) {
               a.add(temp.pop());
           }
           }
    }

    static void reverseArrayList2(ArrayList<Integer>a) {
           if ( (a != null ) && (a.size()>1)) {
               Collections.reverse(a);
           }
    }

    static int fib(int n) {
      if (n==0) return 0;
      if (n==1 || n==2) return 1;
      return fib(n-2) + fib(n-1);
    }

    public static String reverseString(String input) {
       
       if (input == null || input.length() <= 1) {
           return input;
       }
        
        Stack<Character> temp=new Stack<>();

       for (int i=0;i<input.length();i++) {
           temp.push(input.charAt(i));
       }
       String result="";
       for (int i=0;i<input.length();i++) {
           result +=temp.pop();
       }
       return result;
    }

 public static int greatestCommonDivider(int p, int q) {
  if (p==0) return q;
if (q==0) return p;
if (p==q) return p;

int min=p<q?p:q;
int result=1;
for (int i=1;i<=min;i++) {
    if ( p%i==0 && q%i==0)  {
       result=i;
    }
}
return result;
 }
public static int greatestCommonDivider2(int p, int q) {
 if (p==0) return q;
if (q==0) return p;
if (p==q) return p;

while (p != q) {
  if (p>q) p=p-q;
  else q=q-p;
}
return q;
}

public static Set<String>findKeysWithCommonValues(Map<String, String>map1, Map<String, String>map2) {

    if (map1 == null || map2 == null) {
        return null;
    }

    Set<String>resultKeys=new HashSet<String>();

    for (Map.Entry<String, String> entry:map1.entrySet()) {
       String thisKey=entry.getKey();
       if (map2.containsKey(thisKey)  && entry.getValue().equals(map2.get(thisKey))) {
             resultKeys.add(thisKey);
       }
    }
    return resultKeys;
}

static int countWords(String sentence) {
    return (sentence.trim().split("\\s+")).length;
}
static String removeDuplicates(String words) {

    //Map<String, String>counts=new HashMap<String, String>();

    int l=words.length();
    String result="";
    for (int i=0;i<l;i++) {
        Character c=words.charAt(i);
        if (result.indexOf(c) == -1) {
             result=result+c;
        }
    }
    System.out.println("result : "+result);

    return result;
}
    

static StringBuilder edit(StringBuilder originalText) {
        return originalText.delete(2, 3);  
}

static void convertn(String e) throws NumberFormatException {
   if ((e==null) || !e.matches("[0-9]+")) {
       throw new NumberFormatException();
   }
   int a=Integer.parseInt(e);
   int b=Integer.valueOf(e);
   int c=Integer.decode(e);
   System.out.println("int values : " + a + " " + b + " "+ c);
}
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
    public static char firstNonRepeating(String input) {
        if (input == null || input.length()==0) {
            return ' ';
        }
        int l=input.length();

        for (int i=0;i<l;i++) {
            char c=input.charAt(i);
            if ( (input.indexOf(c) != -1) && (input.lastIndexOf(c) == input.indexOf(c))) {
                return c;
            }
        }
        return ' ';

    }
    public static boolean noonly(String input) {

        return input.matches("[0-9]+");
    }
    public static String reverseS(String input) {
           if (input == null || input.length()<=1) {
               return input;
           }
           int l=input.length();
           String result="";
           for (int i=l-1;i>=0;i--) {
             result+=input.charAt(i);
           }
           return result;
    }

    public static boolean isAnagram2(String s1, String s2) {
           if (s1 == null || s2 == null ) return false;
           int l1=s1.length(), l2=s2.length();
            if (l1 != l2) return false;
            
            String[]a1=s1.trim().split("");
            String []a2=s2.trim().split("");
            Arrays.sort(a1);
            Arrays.sort(a2);

            if (!Arrays.equals(a1, a2)) return false;
            return true;

    }

    public static boolean isAnagram3(String s1, String s2) {
           if (s1 == null || s2 == null ) return false;
           int l1=s1.length(), l2=s2.length();
            if (l1 != l2) return false;
            
            char []a1=s1.toCharArray();
            char []a2=s2.toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);

            if (!Arrays.equals(a1, a2)) return false;
            return true;

    }

    public static boolean isAnagram4(String s1, String s2) {
           if (s1 == null || s2 == null ) return false;
           int l1=s1.length(), l2=s2.length();
            if (l1 != l2) return false;
            
            Map<Character, Integer>counts=new HashMap<>();
            
            for (int i=0;i<l1;i++){
                Character c1=s1.charAt(i);
                if (counts.containsKey(c1)) {
                   counts.put(c1, counts.get(c1)+1);
                } else {
                    counts.put(c1, 1);
                }
            }
            for (int i=0;i<l2;i++) {
                Character c2=s2.charAt(i);
                if (counts.containsKey(c2)) {
                   counts.put(c2, counts.get(c2)-1);
                } else {
                    counts.put(c2, 1);
                }

            }
            for (Character ckey: counts.keySet()) {
                    if (counts.get(ckey) != 0) {
                        return false;
                    }
            }
            return true;

    }

        public static List<String>  mysearch(List<String> myList) {

            return myList.stream().filter(a -> a.startsWith("a")).filter(a -> a.length()==3).collect(Collectors.toList());
        }

        public static String getString(List<Integer>mylist){
         return mylist.stream().map(  e -> (e%2==0)?"e"+e:"o"+e).collect(Collectors.joining(","));
       
        }

        public static void distincePrint1(List<Integer>mylist){
              mylist.stream().distinct().forEach(System.out::println); 
        }

        public static long distinceCount1(List<Integer>mylist){
              return mylist.stream().distinct().count(); 
        }

        public static long getMax(List<Integer>myList) {

            return myList.stream().max(Comparator.naturalOrder()).get();
        }

        public static double getAverage(List<Integer>myList) {

            OptionalDouble double1=myList.stream().mapToInt(x -> x).average();
            if (double1.isPresent()) {
                return double1.getAsDouble();
            }
            return 0;
        }

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

        public static int getMax3(List<Integer>mylist) {
          return mylist.stream().max(Comparator.naturalOrder()).get();
        }

        public static int getMax4(List<Integer>mylist) {
          if (mylist == null) return -1;
          if (mylist.size()==1) return mylist.get(0);
          int maxn=mylist.get(0);
          for (int i=1;i<mylist.size();i++) {
              if (mylist.get(i) > maxn) maxn=mylist.get(i);
          }
            return maxn;
         }
  public static boolean isPangram(String input) {
      if (input == null || input.trim().length() < 26) {
          return false;
      }
      String nospace=input.trim().replaceAll("\\s+", "").toLowerCase();
      int l=nospace.length();
      Set<Character>result=new HashSet<>();
      for (int i=0;i<l;i++) {
          result.add(nospace.charAt(i));
      }
      System.out.println("set : " + result.toString());
      if (result.size() == 26) return true;
      return false;

  }

  //HashMap to list using stream
   public static List<String> mapToListUsingStream(HashMap<String, String> books) {
      List<String> codes = books.entrySet().stream()
     .filter(e -> e.getValue().startsWith("java"))
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());

      return codes;
   }



  //chars :  arrayOfCharacters to stream
  public static boolean isPangram2(String input) {
      if (input == null || input.trim().length() < 26) {
          return false;
      }
      String nospace=input.trim().replaceAll("\\s+", "").toLowerCase();
      return (nospace.chars().filter(  c -> ( c>='a' && c<='z') ).distinct().count() == 26);

  }

  public static boolean isPalindrome(int number) {

       String inputS=String.valueOf(number);
       int l=inputS.length();
       if (l==1) return true;
       for (int i=0;i<l;i++) {
            char c=inputS.charAt(i);
           if (inputS.charAt(i) != inputS.charAt(l-1-i)) {
               return false;
           }
       }
       return true;
  }


  

 public static boolean lt_buddyStrings(String A, String B) {
        if (A == null || B == null) return false;
        if ( (A.length() == 0) || (B.length() == 0)) return false;
        
        if (A.length() != B.length()) return false;
        
        Map<Character, Integer>mapA=new HashMap<>();
        int l=A.length();
    
        
        for (int i=0;i<l;i++) {
            Character c=A.charAt(i);
            if (!mapA.containsKey(c)) {
                mapA.put(c, 1);
            } else {
                mapA.put(c, mapA.get(c)+1);
            }
        }
        boolean evenRepeat=true;
        for (Character cc:mapA.keySet()) {
            if (mapA.get(cc) % 2 != 0) {
                evenRepeat=false;
                break;
            }
        }
        for (int i=0;i<l;i++) {
            Character cb=B.charAt(i);
            if (!mapA.containsKey(cb)) {
                return false;
            } 
            mapA.put(cb, mapA.get(cb)-1);
            
        }
        if (mapA.size() ==1) {
            return mapA.get(A.charAt(0)) == 0;
        }
        int count=0;
        for (Character c: mapA.keySet()) {
           
            if (mapA.get(c) != 0) {
                return false;
            }
            if (A.indexOf(c) != B.indexOf(c)) {
                count++;
            }
        }
       
        if (count==2) {
            return true;
        } 
        if (count ==0 && evenRepeat) {
            return true;
        }
        return false;
        

    }
    
    public int lt_thirdMax(int[] nums) {
       Arrays.sort(nums);
       int l=nums.length;
       if (l < 3) return nums[l-1];
        
       int max=nums[l-1];
        
       for (int i=l-2;i>0;i--) {
           if (nums[i]==max) {
               continue;
           } else {
               if (nums[i]>nums[i-1]) {
                   return nums[i-1];
               } else {
                   continue;
               }
           }
       }
       return max;
    }

    static public boolean lt_validPalindrome(String s) {
        int l=s.length();
        if (l==1) {
            return true;
        }
        if (isPalindrome(s)) {
            return true;
        }
        for (int i=1;i<l;i++) {
            if (isPalindrome(s.substring(0, i) + s.substring(i+1, l)) ) {
                return true;
            }
        }
        return false;
        
        
    }
    

    public static boolean isPalindrome(String ss){
        System.out.println("ss : "+ss);
        int ll=ss.length();
        if (ll==1) {
            return true;
        }
        for (int i=0;i<ll;i++) {
            if (ss.charAt(i) != ss.charAt(ll-1-i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //System.out.println(twoStrings("hello", "world"));
        //System.out.println(twoStrings("hi", "world"));
        System.out.println("valid p : "+lt_validPalindrome("abca"));
        System.out.println(lt_buddyStrings("ab", "ba"));
        System.out.println("IsPalindrome : "+isPalindrome(1234321));
        System.out.println("IsPalindrome : "+isPalindrome(12344321));
        System.out.println("IsPalindrome : "+isPalindrome(12341));
        System.out.println("ISPangram : "+isPangram("abd"));
        System.out.println("ISPangram : "+isPangram("abcD efg hijklmnopqrst uvwxyz"));

        System.out.println("ISPangram 2 : "+isPangram2("abd"));
        System.out.println("ISPangram 2v: "+isPangram2("abcD efg hijklmnopqrst uvwxyz"));


        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(5);

        System.out.println("Max : "+getMax4(list));
        System.out.println(isAnagram4("abcd", "dabc"));
        System.out.println(isAnagram4("abce", "dabc"));
        System.out.println(isAnagram3("abcd", "dabc"));
        System.out.println(isAnagram3("abcd", "dabd"));
        System.out.println("reverse : "+reverseS("abcd"));
        System.out.println(noonly("a9b"));
        System.out.println(noonly("99910"));
        System.out.println("first non repeating : " +firstNonRepeating("babac"));
        findMaxOccurance("aabdaaa");
        convertn("981");
        System.out.println(removeDuplicates(" abd aade "));
        System.out.println("words count : " +countWords(" abd gds   adf "));
        ArrayList<Integer>input=new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(1);
        input.add(4);
        //Static methods of Arrays
        List<Integer>al=Arrays.asList(1, 2, 3);
        for (int a : al) {
            System.out.println(a);
        }

        System.out.println(Arrays.equals(new int[] {1, 2, 3}, new int[]{1, 2, 3}));

        int[]c=Arrays.copyOf(new int[]{6, 2, 3}, 5);
        c[3]=4;
        c[4]=5;
        System.out.println(Arrays.toString(c));
        Arrays.sort(c);
        System.out.println("array binary search : " +Arrays.binarySearch(c, 2));
        //Static methods of Collections
        List<String> e=new ArrayList<>();
        List<String> f=new ArrayList<>();
        e.size();
        e.add("a");
        e.add("b");
        e.add(1, "c");
        List<String>immutableList=Collections.emptyList();
        
        System.out.println(e.isEmpty());
        System.out.println(immutableList.isEmpty());
        Collections.copy(e, f);
        System.out.println("are 2 list equals ? " +e.equals(f));
        System.out.println(e.contains(e.get(0)));
        e.sort(Comparator.reverseOrder());
        System.out.println("reversed : "+e.toString());
        e.forEach(a -> {
             System.out.println(a + " ");
             System.out.println(e.indexOf("1"));
             System.out.println(e.lastIndexOf("a"));
             System.out.println(e.indexOf("a"));
        });

        int i=Collections.binarySearch(e, "a");
        System.out.println("index from binary search : "+i);
        System.out.println("max : "+Collections.max(al));
        System.out.println("min : " +Collections.min(al));
        System.out.println("frequency : " + Collections.frequency(al,al));
        System.out.println("indexOfSubList : "+Collections.indexOfSubList(al, al));
        System.out.println("indexOfSubList : "+Collections.lastIndexOfSubList(al, al));
        Collections.indexOfSubList(e, f);
        //Collections.addAll(al, 1, 5, 6);
        Collections.sort(al);
        al.forEach(System.out::print);
        al.forEach(a->System.out.println(a));
        
        al.stream().anyMatch(pre->pre==2);
        Stream.of(al).forEach(System.out::print);
        
        List<Integer>ee=new ArrayList<>();

        ee.stream().map(a->a*2).filter(a -> a!=null).filter(a->a>0).findFirst().orElse(null);
        Stream<Integer>infiniteStream=Stream.iterate(1, t->t*2);
        infiniteStream.skip(3).limit(4).collect(Collectors.toList());
        
        



    

        //List<Integer> input=Arrays.asList(1, 2, 1, 4);
        System.out.println( removeDuplicates(input));
        removeDuplicates2(input);
        System.out.println(input);

        reverseArrayList(input);
        System.out.println(input);

        reverseArrayList2(input);
        System.out.println(input);

        reverseArrayList2(input);
        System.out.println(input);

        reverseArrayList2(input);
        System.out.println(input);

        System.out.println(fib(5));
        System.out.println(fib(4));
        System.out.println(reverseString("abdedc"));
        System.out.println(greatestCommonDivider(55, 5));


        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("A", "Apple");
        map1.put("B", "Ball");
        map1.put("C", "Cat");
        map1.put("G", "Gun");
        map1.put("I", "Ice");
        map1.put("K", "Kite");
        map1.put("M", "Mat");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("A", "Ant");
        map2.put("B", "Ball");
        map2.put("C", "Cat");
        map2.put("G", "Gun");
        map2.put("I", "Ink");
        map2.put("M", "Moon");
        System.out.println("The set of keys with common values are " + findKeysWithCommonValues(map1, map2));

        /**
        Scanner input= new Scanner(System.in);
        int l=input.nextInt();
        
        String org=input.next();
        int opNo=input.nextInt();
        List<Integer>result=new ArrayList<>();;
        /**
        Scanner input= new Scanner(System.in);
        int l=input.nextInt();
        
        String org=input.next();
        int opNo=input.nextInt();
        List<Integer>result=new ArrayList<>();;
        /**
        Scanner input= new Scanner(System.in);
        int l=input.nextInt();
        
        String org=input.next();
        int opNo=input.nextInt();
        List<Integer>result=new ArrayList<>();;
        /**
        Scanner input= new Scanner(System.in);
        int l=input.nextInt();
        
        String org=input.next();
        int opNo=input.nextInt();
        List<Integer>result=new ArrayList<>();;


        for (int i=0;i<opNo;i++) {
           String op=input.next();
           if (op.toLowerCase().indexOf("insert") != -1) {
              String data=input.next();
              
              Integer index=Integer.valueOf((data.trim().split(" "))[0]);
              Integer charData=Integer.valueOf((data.trim().split(" "))[1]);

              if (index<l && index>=0) {
                  result.add(index, charData);
              }
           }
           if (op.toLowerCase().indexOf("delete") != -1) {
               String data=input.next();
               Integer p=Integer.valueOf(data.trim());
               result.remove(0);
           }
        }
           StringBuilder resultString=new StringBuilder();
           for (int i=0;i<result.size();i++) {
               if (i != result.size()-1) {
                 resultString.append(result.get(i)+" ");
               } else {
                 resultString.append(result.get(i));
               }
           }
           System.out.print(result);
           **/

          
        StringBuilder originalText = new StringBuilder("ABC");
        StringBuilder text = originalText;
        originalText.append("DEF");
        originalText = edit(text);
        originalText = text.append("XYZ");        
        System.out.println("result : ");
        System.out.println(originalText);
    
          
  }
}
