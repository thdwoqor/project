package gg.your.project.domain.account;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SearchFullNameTest {

    @Test
    void 검색용_이름은_공백을_제거한다() {
        SearchFullName searchFullName = SearchFullName.from("난 우리팀의 노력과 열정을 믿#kr2");

        Assertions.assertThat(searchFullName.getSearchFullName()).isEqualTo("난우리팀의노력과열정을믿#kr2");
    }

    @Test
    void 검색용_이름은_대소문자를_구별하지_않는다() {
        SearchFullName searchFullName1 = SearchFullName.from("난 우리팀의 노력과 열정을 믿#kr2");
        SearchFullName searchFullName2 = SearchFullName.from("난 우리팀의 노력과 열정을 믿#KR2");

        Assertions.assertThat(searchFullName1.getSearchFullName()).isEqualTo(searchFullName2.getSearchFullName());
    }

    @Test
    void 검색용_이름에서_구분자가_없는경우_예외가_발생한다() {
        assertThatThrownBy(() -> SearchFullName.from("난 우리팀의 노력과 열정을 믿kr2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("태그를 확인해 주세요");
    }
}
