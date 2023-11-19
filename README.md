# spark-scala-learning

### Requirements

You'll need to have an application.conf file created with elements appropriate for your environment.  An example of that file is as follows:

```
snowflakeConfig (
    account: String,
    username: String,
    password: String,
    role: String,
    schema: String,
    warehouse: String
)
```
You will also need to have a folder called: _output in the same location in which you are running the gen-data class.  CSV files generated are placed into that directory with a current time stamp.

# Background

