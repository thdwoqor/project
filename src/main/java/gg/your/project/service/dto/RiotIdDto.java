package gg.your.project.service.dto;

public record RiotIdDto(
        String gameName,
        String tagline
) {
    public static RiotIdDto from(final String fullName) {
        if (!fullName.contains("#")) {
            throw new IllegalArgumentException("태그를 확인해 주세요");
        }

        String[] split = fullName.split("#");
        return new RiotIdDto(split[0], split[1]);
    }
}
