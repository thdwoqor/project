package gg.your.project.service.dto;

public record RiotIdDto(
        String gameName,
        String tagline
) {
    public static RiotIdDto from(final String fullName) {
        if (!fullName.contains("#")) {
            throw new IllegalArgumentException("소환사를 찾을 수 없습니다.");
        }

        String[] split = fullName.split("#");
        return new RiotIdDto(split[0], split[1]);
    }
}
