package pri.roggu.moduleapi.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.roggu.moduleapi.booking.service.BookingService;
import pri.roggu.modulecommon.domain.dto.BookingDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping(value = "")
    public ResponseEntity<String> booking(@RequestBody BookingDto bookingDto) {
        return bookingService.booking(bookingDto);
    }

}
