import java.util.Scanner;

public class ArrayClass {

    public static void main(String[] args) {

        Scanner continueSC = new Scanner(System.in);
        char[] letters = {'a', 'b', 'c', 'd', 'e'}; 
        boolean continueProgram = true; // variable to loop the program. para makaulit ng operation w/o restarting the program
        while (continueProgram) {
            Menu(letters);
            letters = operations(letters); 
            
            System.out.println("Continue? \nPress 1 For Yes \nPress any number for No");
            int response = continueSC.nextInt();

            if (response != 1) {
                System.out.println("Thank you"); 
                continueProgram = false; }}
        
    }

    public static void Menu(char[] letters) { //Method to display the initial array value and operation option
        System.out.println("The original array elements are:");
        for (int i = 0; i < letters.length; i++) {
            System.out.println(letters[i]);
        }
        System.out.println("Please Select an operation:");
        System.out.println("Press 1 for Insert \nPress 2 for Delete \nPress 3 for Update \nPress 4 for Retrieve \nPress 5 to count the number of elements in the array");
    }

    public static char[] operations(char[] letters) { //method for the 5 operations
        Scanner sc = new Scanner(System.in);
        int ops = sc.nextInt();
        switch (ops) {
            case 1:
            	
                 System.out.println("Please enter a character to insert");
                 char insertVal = sc.next().charAt(0);

                 
                 if (letters.length >= 10) { // Check if the array is full
                     System.out.println("Array is full. Cannot insert more characters.");
                 } else {
                     // Create a new array. Bawal iincrement ang array legth sa java directly kaya need nito
                     char[] incrementLetters = new char[letters.length + 1];

                     // Copy elements from the old array to the new array
                     for (int i = 0; i < letters.length; i++) {
                     	incrementLetters [i] = letters[i];
                     }

                     // Insert the new character at the end
                     incrementLetters [incrementLetters .length - 1] = insertVal;

                     // Passing 'incrementLetters' value to original 'letters' array
                     letters = incrementLetters ;

                     System.out.println("Character '" + insertVal + "' inserted into the array at the end.");

                     // Print the new array values
                     System.out.println("New array elements after insert operation:");
                     for (int i = 0; i < letters.length; i++) {
                         System.out.println(letters[i]);
                     }
                 }
                                 
                return letters; // Return the modified array
            case 2:
                
                System.out.println("Please enter a character to delete");
                char deleteVal = sc.next().charAt(0); // Read a character input from the user and store it in deleteVal

              
                boolean foundD = false; // variable to determine whether the character is found or not
                int newLength = 0; // Initialize a variable to keep track of the new length


             // Iterate through the 'letters' array to find and delete the specified character
             for (int i = 0; i < letters.length; i++) {
                 if (letters[i] == deleteVal) {
                     foundD = true; 
                     continue; //dito na-delete. continue means iiskip niya yung current index
                 }
                 letters[newLength] = letters[i]; // Copy non-deleted elements to the left
                 newLength++; // Increment the new length counter para same length pa rin yung array after magtanggal ng isa
             }

            
             char[] updatedLetters = new char[newLength];

             
             System.arraycopy(letters, 0, updatedLetters, 0, newLength); //medyo complicated, explain ko sa personal

          
             letters = updatedLetters;

             
             if (foundD) {
                 System.out.println("Character '" + deleteVal + "' deleted from the array.");
             } else {
                 System.out.println("Character '" + deleteVal + "' not found in the array.");
             }

            
             System.out.println("New array elements after delete operation:");
             for (int i = 0; i < letters.length; i++) {
                 System.out.println(letters[i]);
             }

          
             return letters;
            case 3:
            	
            	    System.out.println("Please enter the position to update (0 to " + (letters.length - 1) + "): ");
            	    int updatePos = sc.nextInt();

            	    if (updatePos < 0 || updatePos >= letters.length) {
            	        System.out.println("Invalid position. Position should be between 0 and " + (letters.length - 1) + ".");
            	    } else {
            	        System.out.println("Please enter the new character value: ");
            	        char newChar = sc.next().charAt(0);

            	        letters[updatePos] = newChar; //ovverides the value of index on updatePos
            	        System.out.println("Character at position " + updatePos + " updated to '" + newChar + "'.");
            	        
            	        System.out.println("New array elements after update operation:");
            	        for (int i = 0; i < letters.length; i++) {
            	            System.out.println(letters[i]);
            	        }
            	    }
                return letters; // Return the original array

            case 4:
            	 
                 System.out.println("Please enter a character to retrieve");
                 char retrieveVal = sc.next().charAt(0);

                 // Search for the character in the array
                 boolean foundR = false;
                 for (int i = 0; i < letters.length; i++) {
                     if (letters[i] == retrieveVal) {
                         foundR = true;
                         System.out.println("Character '" + retrieveVal + "' found at position " + i);
                         break; // stop the loop 
                     }
                 }

                 if (!foundR) {
                     System.out.println("Character '" + retrieveVal + "' not found in the array.");
                 }
                
                return letters; // Return the original array
            case 5:
                System.out.println("Number of elements in the array: " + letters.length);
                return letters;
            default:
                System.out.println("Invalid Input. Please refresh the program to try again");
                return letters; // Return the original array
        }
    }
}