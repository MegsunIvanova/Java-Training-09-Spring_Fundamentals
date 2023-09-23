package bg.softuni.mobilele.model.dto;

public record UserLoginDTO(String username, String password) {
    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}
