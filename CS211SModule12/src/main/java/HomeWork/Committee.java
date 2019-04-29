package HomeWork;

import java.time.LocalDate;

public final class Committee {

    //Instance data
    private final String name;
    private final int  numMembers;
    private final Member committeeChair;
    private final LocalDate formationDate;

    //Constructor
    public Committee (String name, int numMembers, Member committeeChair, LocalDate formationDate){

        this.name = name;
        this.numMembers = numMembers;
        this.committeeChair = committeeChair;
        this.formationDate = formationDate;
    }



}//Committee
