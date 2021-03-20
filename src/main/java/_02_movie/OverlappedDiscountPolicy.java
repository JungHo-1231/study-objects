package _02_movie;

import java.util.ArrayList;
import java.util.List;

/** 챕터 9, 의존성 관리하기 예제 추가 */
/** 중복 적용이 가능한 할인 정책 */
public class OverlappedDiscountPolicy extends DiscountPolicy {

    private List<DiscountPolicy> discountPolicies = new ArrayList<>();


    public OverlappedDiscountPolicy(List<DiscountPolicy> discountPolicies, DiscountCondition... conditions) {
        this.discountPolicies = discountPolicies;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each : discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }

        return result;
    }

}

