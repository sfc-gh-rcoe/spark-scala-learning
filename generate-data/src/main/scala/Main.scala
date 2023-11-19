
import pureconfig._
import pureconfig.generic.auto._
import scala.util.Random

object Main extends App {
  final case class snowflakeConfig(
    account: String,
    username: String,
    role: String,
    schema: String,
    database: String,
    warehouse: String,
    password: String 
)

val rand = new scala.util.Random
/*/
println(System.getProperty("user.dir"));
*/
//val curDir = System.getProperty("user.dir");
val snowflakeConf = ConfigSource.default.at("rcoe_demo_azure").load[snowflakeConfig];
printf("%s\n%s\n%s\n%s\n%05d\n".format(snowflakeConf
                                , snowflakeConf.right.get.account
                                , snowflakeConf.right.get.username
                                , snowflakeConf.right.get.database
                                , rand.nextInt(99999)));
}