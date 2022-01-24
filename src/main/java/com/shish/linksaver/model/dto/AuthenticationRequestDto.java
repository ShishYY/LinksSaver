package com.shish.linksaver.model.dto;


    public class AuthenticationRequestDto {
        private String email;
        private String password;

        public AuthenticationRequestDto(String email, String password) {
            this.email= email;
            this.password = password;
        }

        public String getUsername() {
            return email;
        }

        public void setUsername(String username) {
            this.email = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
