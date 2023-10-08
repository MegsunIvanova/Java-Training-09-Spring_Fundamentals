package com.example.pathfinder.model.dto;

import jakarta.validation.constraints.*;

import java.util.Objects;

public final class UserRegistrationDTO {
        @NotEmpty
        @Size(min = 5, max = 20)
        private String username; //Accepts values, which should be at least 2 characters

        @NotEmpty
        @Size(min = 5, max = 20)
        private String fullName;

        @NotEmpty
        @Email
        private String email;

        @Min(0)
        @Max(90)
        private int age;

        @NotEmpty
        @Size(min = 5, max = 20)
        private String password;

        @NotEmpty
        @Size(min = 5, max = 20)
        private String confirmPassword;

        public UserRegistrationDTO() {
        }

        public String getUsername() {
                return username;
        }

        public UserRegistrationDTO setUsername(String username) {
                this.username = username;
                return this;
        }

        public String getFullName() {
                return fullName;
        }

        public UserRegistrationDTO setFullName(String fullName) {
                this.fullName = fullName;
                return this;
        }

        public String getEmail() {
                return email;
        }

        public UserRegistrationDTO setEmail(String email) {
                this.email = email;
                return this;
        }

        public int getAge() {
                return age;
        }

        public UserRegistrationDTO setAge(int age) {
                this.age = age;
                return this;
        }

        public String getPassword() {
                return password;
        }

        public UserRegistrationDTO setPassword(String password) {
                this.password = password;
                return this;
        }

        public String getConfirmPassword() {
                return confirmPassword;
        }

        public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
                this.confirmPassword = confirmPassword;
                return this;
        }

        @Override
        public String toString() {
                return "UserRegistrationDTO{" +
                        "username='" + username + '\'' +
                        ", fullName='" + fullName + '\'' +
                        ", email='" + email + '\'' +
                        ", age=" + age +
                        ", password='" + password != null ? "exist" : "null" + '\'' +
                        ", confirmPassword='" + confirmPassword != null ? "exist" : "null" + '\'' +
                        '}';
        }

}
