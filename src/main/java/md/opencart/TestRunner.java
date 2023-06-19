package md.opencart;


    public static void main(String[] args) throws InterruptedException {
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver driver = driverManager.getDriver();

        driver.get("https://www.google.com/");


    }
}