// package lasilu;

// import org.junit.jupiter.api.Test;
// import lasilu.dao.*;
// import lasilu.util.*;
// import lasilu.controller.*;
// import lasilu.model.*;
// import java.sql.*;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;

// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.*;

// @ExtendWith(MockitoExtension.class)
// class EmailControllerTest {

//     @Mock
//     WaliMuridDAO waliMuridDAO;

//     @Mock
//     EmailUtil emailUtil;

//     @Test
//     void sendEmailToWaliMurid_ShouldSendEmail() throws SQLException {
//         // Create an instance of EmailController with mocked dependencies
//         EmailController emailController = new EmailController(waliMuridDAO, emailUtil);

//         // Prepare test data
//         int kelasId = 1;
//         String from = "11221008@student.itk.ac.id";
//         String subject = "Test Subject";
//         String body = "Test Body";
//         String attachmentPath = "~/Downloads/output.csv";
//         int idSiswa = 1;

//         // Mock the behavior of WaliMuridDAO
//         when(waliMuridDAO.getWaliMuridBySiswaId(anyInt())).thenReturn(Collections.singletonList(mock(WaliMurid.class)));
//         // Invoke the method to be tested
//         emailController.sendEmailToWaliMurid(kelasId, from, subject, body, attachmentPath);

//         // Verify that the expected methods were called with the expected arguments
//         verify(waliMuridDAO).getWaliMuridBySiswaId(idSiswa);

//         // Verify the static method invocation using Mockito
//         verifyStatic(EmailUtil.class, times(1));
//         EmailUtil.sendEmail(any(Email.class));
//     }
// }
