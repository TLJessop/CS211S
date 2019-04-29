package HomeWork;

import java.time.LocalDate;

public final class Committee {

    //Instance data
    private final String name;
    private final int  numMembers;
    private final Member committeeChair;
    private final LocalDate formationDate;

    //Constructor
    private Committee (String name, int numMembers, Member committeeChair, LocalDate formationDate){
        validArgs(name,numMembers,committeeChair,formationDate);
        this.name = name;
        this.numMembers = numMembers;
        this.committeeChair = committeeChair;
        this.formationDate = formationDate;
    }

    public Committee updateName(String newName){
        if (!newName.equals(name)){
            return new Committee(newName,numMembers,new Member(committeeChair.getFirstName(),committeeChair.getLastName(),
                    committeeChair.getAge(),committeeChair.getStatus()),formationDate);
        } else {
            throw new IllegalArgumentException("Name was  already :" + name );
        }
    }


    //Validator
    private void validArgs(String name, int numMembers, Member committeeChair, LocalDate formationDate){
        if (name.isEmpty()){
            throw new IllegalArgumentException("The name cannot be an empty string");
        }

        if (numMembers < 0){
            throw new IllegalArgumentException("Number of members cannot be a negative number");
        }

        if (committeeChair != null){
            throw new IllegalArgumentException("Committee chair cannot be null");
        }

        if (formationDate.isBefore(LocalDate.now().minusDays(30))){
            throw new IllegalArgumentException("Formation date cannot be back dated over 30 days");
        }
    }
}//Committee
