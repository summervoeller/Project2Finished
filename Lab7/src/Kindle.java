public class Kindle {

    private int totalPages;
    private int currentPages;


    // THE DEFAULT CONSTRUCTOR (2 lines bc we have 2 data)
    public Kindle(){

        totalPages = 0; // start from zero pages
        currentPages = 1;

    } // end of default constructor

    //-------------------------------------------------------------------------------------------------

    public Kindle(int theTotalPages){

        totalPages = theTotalPages;
        currentPages = 1;

    }// end of the constructor with 1 parameter

    //-------------------------------------------------------------------------------------------------

    public String toString (){
        return ("Page " + currentPages + " of " + "Page " + totalPages);
    }// end of tostring Method

    //-------------------------------------------------------------------------------------------------

    public void turnPages(){
        currentPages = currentPages + 1;
    } // end of turnPage Method with no parameter

    //-------------------------------------------------------------------------------------------------

    public void turnPages(int numberOfPages){

        if (currentPages + numberOfPages <= totalPages){

            currentPages = currentPages + numberOfPages;

        }else{
            currentPages = totalPages;

            System.out.println("You were on : Page   " + currentPages + totalPages );
            System.out.println("Turning " + numberOfPages + " pages would take you past the last page.");
            System.out.println("You are now on     : Page " + currentPages + "of" + totalPages);

        }//end of if else statement

    }// end of turnPage Method with 1 parameter

}// end of KindleObjectPractice Class
