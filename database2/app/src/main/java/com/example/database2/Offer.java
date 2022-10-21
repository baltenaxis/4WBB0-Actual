package com.example.database2;

public class Offer {
    private String Foodname;
    private String Fooddescription;
    private String Availability;

    public Offer(){
        public String getFoodname() {
            return Foodname;
        }

        public void setFoodname(String Foodname) {
            this.Foodname = Foodname;
        }

        public String getFooddescription() {
            return Fooddescription;
        }

        public void setFooddescription(String Fooddescription) {
            this.Fooddescription = Fooddescription;
        }

        public String getAvailability() {
            return Availability;
        }

        public void setAvailability(String Availability) {
            this.Availability = Availability;
        }
    }

}
