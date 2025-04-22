package chapter08._1interface.movie.reservation;

public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {this.reservationRepository = reservationRepository;}

    public void processReservation(Object request) {
        reservationRepository.insertReservation(request);
    }
}
