package subd.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import subd.model.Program;
import subd.model.Session;
import subd.repository.SessionRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SessionService {
    private SessionRepository sessionRepository;
    public void createSession(Integer id, String name, String place, String DataFrom, String DataTo)
            throws ParseException {
        Session session = new Session();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date dateFrom = sdf.parse(DataFrom);
        Date dateTo = sdf.parse(DataTo);
        session.Constructor(id,name, place, dateFrom, dateTo);
        sessionRepository.save(session);
    }

    public void readSessions() {
        for (Session session: sessionRepository.findAll(PageRequest.of(0,3, Sort.unsorted())).toList()) {
            System.out.println(session);
        }
    }

    public void delSession() {
        sessionRepository.deleteById(1);
    }

    public void updateSession(Integer id, String name, String place, String DataFrom, String DataTo)
            throws ParseException {
        Session session = new Session();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date dateFrom = sdf.parse(DataFrom);
        Date dateTo = sdf.parse(DataTo);
        session.Constructor(id,name, place, dateFrom, dateTo);
        sessionRepository.save(session);
    }

    public List<Session> getAllByNameEquals(String name) {
        return sessionRepository.getAllByNameEquals(name);
    }

}
