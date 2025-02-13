public class User {

    private int rank;
    private int progress;

    public User(){
        rank = -8;
        progress = 0;
    }

    public int getRank(){
        return rank;
    }
    public int getProgress(){
        return progress;
    }

    public void incProgress(int activityRank){
        if(activityRank > 8 || activityRank == 0 || activityRank < -8){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }else{
            int calculatedProgress = getCalculatedProgress(activityRank);
            progress += calculatedProgress;
            while(progress >= 100){
                progress -= 100;
                rank = rank!= -1 ? rank + 1 : rank + 2;
            }

        }
    }

    private int getCalculatedProgress(int activityRank) {
        int diff = (this.rank < 0 && activityRank > 0 || this.rank>0 && activityRank < 0) ? Math.abs(this.rank- activityRank)-1 : this.rank - activityRank;
        int calculatedProgress;
        if(activityRank == this.rank){
            calculatedProgress = 3;
        }else if(this.rank - 1 == activityRank){
            calculatedProgress = 1;
        }else if(this.rank == 1 && activityRank == -1){
            calculatedProgress = 1;
        }
        else{
            calculatedProgress = (diff*diff * 10);
        }
        return calculatedProgress;
    }

    public String toString(){
        return "User{" + "rank=" + rank + ", progress=" + progress + '}';
    }

}
