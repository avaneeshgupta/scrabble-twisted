/* package whatever; // don't place package name! */
package scrabble;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;




 class Scrabble {

     private static void permutations(String prefix, String str, ArrayList<String> perms)

     {
         int n = str.length();
         perms.add(prefix);
         if(n!=0)
         {
             for (int i = 0; i < n; i++)

                 permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),perms);  
         }
     }
     
     


     private static ArrayList<String> permutations(String string)
     {
         ArrayList<String> perms = new ArrayList<String>();
         permutations("",string,perms);
         /*
         for(String word: perms)
                 System.out.println(word);
         */
         return perms;
     }

     public static String scoreEvaluation(String str2)
     {
    	 
    	 ArrayList<String> perms = new ArrayList<String>();
         perms = permutations(str2);
        // Iterator itr = perms.iterator();
         String s=""; 
         int max = 0;
         for (String str : perms)
         {
        	//System.out.println(str);
    	    
             int a[]=new int[27];
             for(int i=0;i<27;i++)
            	 a[i]=0;
             
            
             for(int i=0;i<str.length();i++)
                     a[(str.charAt(i)-'a')]++;
             
             //HashMap<String,Integer> hm=new HashMap();
             BufferedReader bReader = null;
             String line = "";
             try {
                     bReader = new BufferedReader(new FileReader("C:\\GitRepo\\scrabble-1\\sowpods.txt"));
                     while((line = bReader.readLine())!=null)                   	 
                     {
                    	     int b[]=new int[27];
                             //s = line;
                    	    // System.out.println(line);
                             b=a.clone();int i;
                             for(i=0;i<line.length();i++)
                             {       
                                             if(b[(line.charAt(i)-'a')]==0)
                                                             break;
                                             else   b[(line.charAt(i)-'a')]--;
                             }
                             if(i==line.length() && i<=7)
                             {
                            	 //System.out.println("hi");
                            	 if(getScore(line)>max)
                            	 {
                            		 
                                     max = getScore(line);
                                   //  System.out.println(line+" "+max);
                                     s=line;	
                            	 }
                             } 
                     } 
             	}
             catch(Exception e){
            	 
             }  
         }
             return s;
     }
     
     private static final String ONE_POINTERS = "eaionrtlsu";
     private static final String TWO_POINTERS = "dg";
     private static final String THREE_POINTERS = "bcmp";
     private static final String FOUR_POINTERS = "fhvwy";
     private static final String FIVE_POINTERS = "k";
     private static final String EIGHT_POINTERS = "jx";
     private static final String TEN_POINTERS = "qz";
     
     public static int getScore(String word) {
         int points = 0;
         char []characters = word.toCharArray();
         for (char c : characters) {
             if (ONE_POINTERS.indexOf(c) != -1) {
                 points += 1;
             }
             else if (TWO_POINTERS.indexOf(c) != -1) {
                 points += 2;
             }
             else if (THREE_POINTERS.indexOf(c) != -1) {
                 points += 3;
             }
             else if (FOUR_POINTERS.indexOf(c) != -1) {
                 points += 4;
             }
             else if (FIVE_POINTERS.indexOf(c) != -1) {
                 points += 5;
             }
             else if (EIGHT_POINTERS.indexOf(c) != -1) {
                 points += 8;
             }
             else {
                 points += 10;
             }
         }
         return points;
     }
	
	private static String maxScoreWord(String word) {

/*	//Receiving all possible permutations of tiles
			
//			HashMap<String,Integer> map = scoreEvaluation(word);
//			ArrayList<String> perms = permutations(word);
//			int max = 0;
//			String maxScoreString = "";
//			for(int i=0;i<perms.size();i++){
//				int score = map.get(word);
//				if(score>max){
//					score = max;
//					maxScoreString = perms.get(i);
 * 
//				}
//			} */
            return scoreEvaluation(word);
            
	}
            
       private static String maxScoreWord2(String str2,char letter,int front,int back)
       { 
    	 ArrayList<String> perms = new ArrayList<String>();
         perms = permutations(str2);
        // Iterator itr = perms.iterator();
         String s=""; 
         int max = 0;
         for (String str : perms)
         {
        	//System.out.println(str);
    	    
             int a[]=new int[27];
             for(int i=0;i<27;i++)
            	 a[i]=0;
             
            
             for(int i=0;i<str.length();i++)
                     a[(str.charAt(i)-'a')]++;
             
             //HashMap<String,Integer> hm=new HashMap();
             BufferedReader bReader = null;
             String line = "";
             try {
                     bReader = new BufferedReader(new FileReader("C:\\GitRepo\\scrabble-1\\sowpods.txt"));
                     while((line = bReader.readLine())!=null)                   	 
                     {
                    	     int b[]=new int[27];
                             //s = line;
                    	    // System.out.println(line);
                             b=a.clone();int i;
                             for(i=0;i<line.length();i++)
                             {       
                                             if(b[(line.charAt(i)-'a')]==0)
                                                             break;
                                             else   b[(line.charAt(i)-'a')]--;
                             }
                             if(i==line.length() && ifpossible(line,letter,front,back))
                             {
                            	 //System.out.println("hi");
                            	 if(getScore(line)>max)
                            	 {
                            		 
                                     max = getScore(line);
                                   //  System.out.println(line+" "+max);
                                     s=line;	
                            	 }
                             } 
                     } 
             	}
             catch(Exception e){
            	 
             }  
         }
            
         return s;
    	   
    	   
    	   
    	   
    	   
    	   
    	   
       }
       private static boolean ifpossible(String word,char letter,int front,int back)
       {
    	   int index = word.indexOf(letter); 
    	   int size = word.length();
    	   
    	   while (index >= 0) 
    	   {
    		   
    	      
    	   if( index <= front && size-index-1<=back)
    		   return true;
    	   index = word.indexOf(letter, index + 1);
    	   
    	   
    	   }
    	   return false;
    	   
       }
            

    

    public static void main(String[] args) {

            // TODO Auto-generated method stub

            

            String word = "taken";
            System.out.println(maxScoreWord2(word,'t',1,2));
              //System.out.println(word);
              
           /*   ArrayList<String> perms = new ArrayList<String>();
              perms = permutations(word);
              Iterator itr = perms.iterator();
              while(itr.hasNext())
              {
              	System.out.println(itr.next());
              } 
          
           */
         //   System.out.println(getScore());
            
            
    }

    

}

