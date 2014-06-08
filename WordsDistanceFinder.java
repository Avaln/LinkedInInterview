import java.util.*;
public class WordsDistanceFinder{
  private HashMap<String, List<Integer>> distance;
  
  public WordsDistanceFinder(String[] words){
    distance = new HashMap<String, List<Integer>>();
    this.constructDistanceTable(words);
  }
  
  private void constructDistanceTable(String[] words){
    for(int i = 0; i< words.length; i++){
      if(distance.containsKey(words[i]))
        distance.get(words[i]).add(i);
      else{
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(i);
        distance.put(words[i], l);
      }  
    }
  }
  
  // 1   3    6
  // 5   8
  public int distance(String w1, String w2){
    ArrayList<Integer> l1 = (ArrayList<Integer>)this.distance.get(w1);
    ArrayList<Integer> l2 = (ArrayList<Integer>)this.distance.get(w2);
    
    int i = 0;
    int j = 0;
    int distance = 0;
    while(i <= l1.size() && j <= l2.size()){
      if(distance > Math.abs(i - j))
        distance = Math.abs(i-j);
        
      if(l1.get(i) <= l2.get(j))
        i++;
      else
        j++;
    }
    
    if( i > l1.size()){
      i--;
      while( j <= l2.size()){
        j++;
        if(distance > Math.abs(i - j))
          distance = Math.abs(i-j);
      }
    }else if( j > l2.size()){
      j--;
      while( i <= l1.size()){
        i++;
        if(distance > Math.abs(i - j))
          distance = Math.abs(i-j);
      }
    }
    
    return distance;
  }
  
  public static void main(String[] args){
	  WordsDistanceFinder finder = new WordsDistanceFinder(new String[] {"ab", "de", "ab", "cd", "ff", "ab", "ac", "ff"}); 
      int distance = finder.distance("ab", "ff");
      System.out.println(distance);
  }
 
}