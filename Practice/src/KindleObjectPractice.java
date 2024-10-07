public class KindleObjectPractice {

    private int totalPages;
    private int currentPages;


    // THE DEFAULT CONSTRUCTOR (2 lines bc we have 2 data)
    public KindleObjectPractice(){

        totalPages = 0; // start from zero pages
        currentPages = 1;

    } // end of default constructor

    //-------------------------------------------------------------------------------------------------

    public KindleObjectPractice(int theTotalPages){

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




        }//end of if else statement




    }// end of turnPage Method with 1 parameter

}// end of KindleObjectPractice Class
