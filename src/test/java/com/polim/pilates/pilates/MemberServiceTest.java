package com.polim.pilates.pilates;

import com.polim.pilates.pilates.entity.Member;
import com.polim.pilates.pilates.entity.PilatesClass;
import com.polim.pilates.pilates.repository.MemberRepository;
import com.polim.pilates.pilates.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void shouldFailEnrollmentWhenClassIsFull() {
        // Arrange: Create a class with capacity 1 and 1 existing member
        PilatesClass fullClass = new PilatesClass();
        fullClass.setCapacity(1);
        fullClass.getEnrolledMembers().add(new Member());

        // Act & Assert: Verify the exception is thrown
        assertThrows(RuntimeException.class, () -> {
            memberService.enrollMemberInClass(fullClass, new Member());
        });
    }
}