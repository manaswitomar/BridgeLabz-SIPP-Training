import java.util.Stack;
interface NavigationManager {
    void visitPage(String url);
    void goBack();
    void goForward();
    void currPage();
}
class BrowserNavigation implements NavigationManager {
    Stack<String> backStack = new Stack<>();
    Stack<String> forwardStack = new Stack<>();
    String curr;
    @Override
    public void visitPage(String url) {
        if(backStack.isEmpty()){
            backStack.push(curr);
        }
        else if (curr!=null) {
            backStack.push(curr);
        }
        curr = url;
        forwardStack.clear();  
        System.out.println("Visited: " + curr);
    }
    @Override
    public void goBack() {
        if(!backStack.isEmpty()){
            forwardStack.push(curr);
            curr=backStack.pop();
            System.out.println("visited current page"+curr);
        }
        else{
            System.out.println("no page in back exists in backstack");
        }
    }
    @Override
    public void goForward() {
        if(!forwardStack.isEmpty()){
            backStack.push(curr);
            curr=forwardStack.pop();
            System.out.println("visited current page"+curr);

        }
        else{
            System.out.println("no pages exist in forward stack");
        }
    }
    @Override
    public void currPage() {
        System.out.println("Current page is"+curr);
    }
    public static void main(String[] args){
        BrowserNavigation navigation=new BrowserNavigation();
        navigation.visitPage("google.com");
        navigation.visitPage("gmail");
        navigation.visitPage("chatai");
        navigation.goBack();
        navigation.goForward();
        navigation.currPage();

    }
    
}
class MobileBrowserNavigation extends BrowserNavigation {
    @Override
    public void visitPage(String url) {
        System.out.print("[Mobile] ");
        super.visitPage(url);
    }
}



