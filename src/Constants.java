public class Constants {
    static private boolean dressed = false;

    static private boolean workFinished = false;

    static private boolean signedIn = false;

    static void getDressed(){
        dressed = true;
    }

    static void signIn(){
        signedIn = true;
    }

    static void finishWork(){
        workFinished = true;
    }

    static boolean isDressed(){
        return dressed;
    }

    static boolean isWorkFinished(){
        return workFinished;
    }

    static boolean isSignedIn() {return signedIn; }
}
