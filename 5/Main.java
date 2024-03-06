import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Function to reconstruct queue
    public static int[] reconstructQueue(int[]height,int[] inFronts){
        int n=height.length;
        int [][] people=new int[n][2];
        for(int individual=0;individual<n;individual++){
            people[individual][0]=height[individual];
            people[individual][1]=inFronts[individual];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if(a1[0]==a2[0]){
                return a1[1]-a2[1];}
                else return a2[0]-a1[0];
            }
        });//Returns the array sorted in descending order
        List<int[]> result = new ArrayList<>();

        for (int[] person : people) {
            result.add(person[1], person); // Insert person at index equals to his inFronts
        }

        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = result.get(i)[0];
        }

        return output;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number of People");
        int n=sc.nextInt();
        int[] heights = new int[n];//Array to store the height of people
        int[] inFronts = new int[n];//Array to store the people in front having equal or more height
        //Take input of height array
        for(int i=0;i<n;i++){
            heights[i]=sc.nextInt();
        }
        //take input for inFronts
        for(int i=0;i<n;i++){
            inFronts[i]=sc.nextInt();
        }
        int []actualOrder=reconstructQueue(heights,inFronts);
        System.out.println("Actual Order of heights is given below:");
        for(int height:actualOrder){
            System.out.print(height+",");
        }
    }
}
