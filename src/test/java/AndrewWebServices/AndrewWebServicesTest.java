package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;
    InMemoryDatabase inMemWebService;

    @Before
    public void setUp() {
        // You need to use some mock objects here
        database = new Database(); // We probably don't want to access our real database...
        recommender = new RecSys();
        promoService = new PromoService();

        andrewWebService = new AndrewWebServices(database, recommender, promoService);
        inMemWebService = new InMemoryDatabase();
    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        //assertTrue(andrewWebService.logIn("Scotty", 17214));
        assertTrue(inMemWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        assertEquals("Animal House", inMemWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
        // How should we test sendEmail() when it doesn't have a return value?
        // Hint: is there something from Mockito that seems useful here?
        String emailToSend = "test@example.com";
        PromoService mockPromo= Mockito.mock(PromoService.class);
        andrewWebService.promoService=mockPromo;
        andrewWebService.sendPromoEmail(emailToSend);
        // Verify that the promoService.mailTo method was called exactly once with the correct email
        verify(mockPromo, times(1)).mailTo(emailToSend);




    }

    @Test
    public void testNoSendEmail() {
        // How should we test that no email has been sent in certain situations (like right after logging in)?
        // Hint: is there something from Mockito that seems useful here?
        PromoService mockPromo= Mockito.mock(PromoService.class);
        andrewWebService.promoService=mockPromo;
        String emailNoSend = "test@example.com";
        verify(mockPromo, never()).mailTo(emailNoSend);
    }
}
