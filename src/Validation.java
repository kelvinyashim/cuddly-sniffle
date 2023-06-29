public class Validation {
    protected boolean isValidName(String name) {
        return !name.isEmpty();
    }

    protected boolean isValidMat(String matNum) {
        return matNum.matches("BHU/\\d{2}/\\d{2}/\\d{2}/\\d{4}");
    }

    public boolean isValidPassword(String password) {
        // Add your password validation logic here
        // Return true if the password is valid; otherwise, return false
        return password.length() >= 8; // Example: Password must be at least 8 characters long
    }


}

