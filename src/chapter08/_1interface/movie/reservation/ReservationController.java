package chapter08._1interface.movie.reservation;

public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {this.reservationService = reservationService;}

    public void requestReservation(Object request) {
        reservationService.processReservation(request);
    }
}
