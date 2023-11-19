import java.io.PrintWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import pureconfig._
import pureconfig.generic.auto._

object MainData {

    final case class generatorParams (
      filePath: String,
      recordQuantity: Int
    )
    
    def main(args: Array[String]): Unit = {
        val rand = new scala.util.Random
        val t_time = LocalDateTime.now()
        val t_format = DateTimeFormatter.ofPattern("HH_mm_ss")
        val t_formattedDate = t_time.format(t_format)
        
        // Create a new file named for args[0]
        // 
        //
        val p = new PrintWriter("_output/userinfo-%s.csv".format(t_formattedDate));

        val f_header = "userName,phoneNumber,socialSecurityNumber,ageBand,loyaltyLevel,emailAddress\n";
        
        //
        // Write the header to the .csv file
        //
        p.append(f_header);
        var f_object = "";

        //
        //
        // Create the number of rows passed in via args[1] of random user profiles
        //
        // for( i <- 1 to args(1).toInt) {
        for( i <- 1 to 5) {
          var f_uname = "username-%05d".format(rand.nextInt(5000));
          var f_phone = "%03d-%03d-%04d".format(rand.nextInt(999), rand.nextInt(99), rand.nextInt(6999));
          var f_ssn = "%03d-%02d-%04d".format(rand.nextInt(399), rand.nextInt(99), rand.nextInt(6999));
          var f_email = "";
          var f_loyaltyLevel = "";
          var f_ageBand = 0;
          var t_ageBand = rand.nextInt(999);

          if ((t_ageBand >= 25) && (t_ageBand <= 50)) {
            f_ageBand = t_ageBand;
            f_loyaltyLevel = "BRONZE";
            f_email = "username-%05d@somedomain.com".format(rand.nextInt(10000));
            f_object = "%s,%s,%s,%s,%s,%s\n".format(f_uname,f_phone,f_ssn,f_ageBand,f_loyaltyLevel,f_email);


          }
          else {
            f_object = "%s,%s,%s,,,\n".format(f_uname,f_phone,f_ssn);
          }
          p.append(f_object);
        }

        //
        ////
        // write the buffer to the file
        p.flush();
    }
}


