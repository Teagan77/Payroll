package org.randall.teagan.Domains.Demography;

public class Gender {

    private String genderId, genderDesc;

    private Gender() {}

    private Gender(GenderBuilder genderBuilder) {
        this.genderId = genderBuilder.genderId;
        this.genderDesc = genderBuilder.genderDesc;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGenderDesc() {
        return genderDesc;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", genderDesc='" + genderDesc + '\'' +
                '}';
    }

    public static class GenderBuilder {

        private String genderId, genderDesc;

        public GenderBuilder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public GenderBuilder genderDesc(String genderDesc) {
            this.genderDesc = genderDesc;
            return this;
        }

        public Gender.GenderBuilder copy(Gender gender) {
            this.genderId = gender.genderId;
            this.genderDesc = gender.genderDesc;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}

