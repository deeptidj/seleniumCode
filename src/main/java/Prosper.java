import java.util.HashMap;

public class Prosper {
    /*
    1. Login
    password
    button
    3 possibilities
    credentials - correct - take them in welcome page



    2. sign in button  - create accout - registration page > first name (special characters) last name (special characters) DOB - manuall and datetime Picker MMDDYY
    Employment field - drop down - unemployed, retired ...
    email address field - valid email formats only
    Password - min charaters 8 (min 1 cap, 1 lower, 1 special character)
     Credit card credit card no. 16 digits min(), cvv 3 to 4 digits , expiry date - MMYY
     registered button -> landing page -->success-->  Welcome page
     if user error --> highlights page on same page,
     If server error --> relevent error page.


      1. test strategy
        1. Test Plan - login
        2. Test plan - sign and registration
        3. Test Plan - mix of above 2 test plans.
        4. Supported Browsers.
        5.
        -
      2. top positive and negative test cases
        1. valid credentials of a registered user should be log in successfully --> landing page.


        1. Wrong credentials -
      3. Automation strategy.


     */
    public static void main(String[] args) {
        int target = 25;
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i = -50; i < 51; i++) {
                int second = target - i;
                if (second >= -50 && second <= 50) {
                    if (hm.get(second) == null) hm.put(i, second);
                }
            }
            System.out.println(hm);
        }
    }
