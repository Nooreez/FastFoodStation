import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        int n = 1;
        String welcomeMessage = "";
        List<String> categories = new ArrayList<String>();
        List<String>[] subcategories= new List[256];
        int[][] price = new int[256][256];
        for(int i = 0 ; i <= 255 ; ++i){
            subcategories[i] = new ArrayList<String>();
        }
        String newMenu;
        int menusize=0;
        System.out.println("Welcome to the Admin Panel of \"Salam Bro\" Fast Food Station!");
        System.out.println("Here you can do the following activities:");
        while(n != 0){
            System.out.print("0. Exit.\n1. Change Welcome Message.\n2. Change Menu. \n3. Change Submenu. \n4. Change Prices.\n5. Display Welcome Message.\n6. Display Menu. \n7. Display Submenu. \n8. Display Prices.\n9. Switch To Client Mode.\n \n Choose an activity: ");
            n = scnr.nextInt();
//            System.out.print(n); // Check it
            if(n == 1){
                System.out.print("\n \n \n");
                System.out.println("Please, type the massege that client will see when enter the menu: ");
                System.out.println("Tip: use underscore (_) as a splitter");
                System.out.print("\n");
                System.out.print(">");
                scnr.nextLine();
                welcomeMessage = scnr.nextLine();
                welcomeMessage = welcomeMessage.replaceAll("_", "\n");
                System.out.print("\n \n \n");
            }
            if(n == 2){
                int n2;
                System.out.print("\n \n \n");
                System.out.print("Here you can do the following activities: \n0.Go back.\n1.Add categories.\n2.Remove categories.\n");
                System.out.print("\n");
                System.out.print("Your choise: ");
                n2 = scnr.nextInt();
//              System.out.print(n2);  Check it
                System.out.print("\n \n");
                if(n2 == 1){
                    System.out.print("Write the names of categories separated by comma (c1, c2, ...)\n");
                    System.out.print(">");
                    scnr.nextLine();
                    String str = scnr.nextLine();
                    String[] words = str.split(",");
                    for(String category: words){
                        category = category.replaceFirst(" ","");
                        categories.add(category);
                    }
                    System.out.print("\n \n");
                }
                if(n2 == 2){
                    if(categories.size() == 0){
                        System.out.print("You don't have a menu yet.\n \n \n");
                    }
                    else{
                        System.out.print("Write the numbers of categories separated by comma (c1, c2, ...)\n");
                        System.out.print(">");
                        scnr.nextLine();
                        String str = scnr.nextLine();
                        String[] numbers = str.split(",");
                        int cnt = 0;
                        for(String number: numbers){
                            number = number.replaceFirst(" ","");
                            int num = Integer.parseInt(number);
                            if(num-cnt-1<categories.size()){
                                cnt++;
                                categories.remove(num-cnt);
                                for(int i = num-cnt ; i < categories.size(); ++i){
                                    subcategories[i] = subcategories[i+1];
                                    price[i] = price[i+1];
                                }
                                subcategories[categories.size()].clear();
                            }
                        }
                        System.out.print("\n \n");
                    }
                }
            }
            if(n == 3){
                int n2;
                System.out.print("\n \n \n");
                System.out.print("Here you can do the following activities: \n0.Go back.\n1.Add subcategories.\n2.Remove subcategories.\n");
                System.out.print("\n");
                System.out.print("Your choise: ");
                n2 = scnr.nextInt();
//              System.out.print(n2);  Check it
                System.out.print("\n \n");
                if(n2 == 1){
                    int n3;
                    System.out.print("Choose a category for which you want to add subcategories:\n");
                    for(int i = 0 ; i < categories.size() ; ++i){
                        System.out.print((i+1) + "." + categories.get(i) + ".\n");
                    }
                    n3 = scnr.nextInt();
                    System.out.print("Write the names of categories separated by comma (c1, c2, ...)\n");
                    System.out.print(">");
                    scnr.nextLine();
                    String str = scnr.nextLine();
                    String[] words = str.split(",");
                    for(String category: words){
                        category = category.replaceFirst(" ","");
                        subcategories[n3-1].add(category);
                    }
                    System.out.print("\n \n");

                }
                if(n2 == 2){
                    int n3;
                    System.out.print("Choose a category from which you want to remove subcategories:\n");
                    for(int i = 0 ; i < categories.size() ; ++i){
                        System.out.print((i+1) + "." + categories.get(i) + ".\n");
                    }
                    n3 = scnr.nextInt();
                    if(subcategories[n3-1].size() == 0){
                        System.out.print("You don't have a subcategories in thus category.\n \n \n");
                    }
                    else{
                        System.out.print("Write the numbers of categories separated by comma (c1, c2, ...)\n");
                        System.out.print(">");
                        scnr.nextLine();
                        String str = scnr.nextLine();
                        String[] numbers = str.split(",");
                        int cnt = 0;
                        for(String number: numbers){
                            number = number.replaceFirst(" ","");
                            int num = Integer.parseInt(number);
                            if(num-cnt-1<subcategories[n3-1].size()){
                                cnt++;
                                subcategories[n3-1].remove(num-cnt);
                                for(int j = num-cnt ; j < subcategories[n3-1].size(); ++j){
                                    price[n3-1][j] = price[n3-1][j+1];
                                }
                            }
                        }
                        System.out.print("\n \n");
                    }
                }
            }
            if(n == 4){
                int n3;
                System.out.print("Choose a category from which you want to change price of subcategories:\n");
                for(int i = 0 ; i < categories.size() ; ++i){
                    System.out.print((i+1) + "." + categories.get(i) + ".\n");
                }
                n3 = scnr.nextInt();
                if(subcategories[n3-1].size() == 0){
                    System.out.print("You don't have a subcategories in thus category.\n \n \n");
                }
                else{
                    System.out.print("Choose subcategories for which you want to change prices:\n");
                    for(int i = 0 ; i < subcategories[n3-1].size(); ++i){
                        System.out.print((i+1) + "." +  subcategories[n3-1].get(i) + " - " + price[n3-1][i] + " kzt.\n");
                    }
                    System.out.print("\n \n");
                    System.out.print("Tip: write the indexes separated by comma (c1, c2, ...)\n");
                    System.out.print(">");
                    scnr.nextLine();
                    String str = scnr.nextLine();
                    String[] numbers = str.split(",");
                    for(String number: numbers){
                        number = number.replaceFirst(" ","");
                        int num = Integer.parseInt(number);
                        if(num-1<subcategories[n3-1].size()){
                            System.out.print("Enter a new price for "+subcategories[n3-1].get(num-1)+": ");
                            int n4 = scnr.nextInt();
                            System.out.print("\n");
                            price[n3-1][num-1] = n4;
                        }
                    }
                    System.out.print("\n \n");
                }
            }
            if(n == 5){
                System.out.print("\n \n");
                if(welcomeMessage == ""){
                    System.out.print("You don't have welcome message yet\n");
                }
                else{
                    System.out.print(welcomeMessage);
                }
                System.out.print("\n \n");
            }
            if(n == 6){
                System.out.print("\n \n");
                if(categories.size()!=0){
                    for(int i = 0 ; i < categories.size() ; ++i){
                        System.out.print((i+1) + "." + categories.get(i) + ".\n");
                    }
                }
                else{
                    System.out.print("You don't have menu yet\n");
                }
                System.out.print("\n \n");
            }
            if(n == 7){
                int n2;
                System.out.print("\n \n");
                System.out.print("Choose a category for which you want to see its subcategories:\n");
                for(int i = 0 ; i < categories.size() ; ++i){
                    System.out.print((i+1) + "." + categories.get(i) + ".\n");
                }
                System.out.print("\n \n");
                n2 = scnr.nextInt();
                if(subcategories[n2-1].size() == 0){
                    System.out.print("\n \n");
                    System.out.print("You don't have subcategories in this category.\n");
                }
                else{
                    for(int i = 0 ; i < subcategories[n2-1].size(); ++i){
                        System.out.print((i+1) + "." +  subcategories[n2-1].get(i) + ".\n");
                    }
                }
                System.out.print("\n \n");
            }
            if(n == 8){
                int n2;
                System.out.print("Choose the category for which you want to see its subcategories' prices\n");
                for(int i = 0 ; i < categories.size() ; ++i){
                    System.out.print((i+1) + "." + categories.get(i) + ".\n");
                }
                System.out.print("\n \n");
                n2 = scnr.nextInt();
                for(int i = 0 ; i < subcategories[n2-1].size(); ++i){
                    System.out.print((i+1) + "." + subcategories[n2-1].get(i) + " - " + price[n2-1][i] + " kzt.\n");
                }
                System.out.print("\n \n");
            }
        }
    }
}