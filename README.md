# ![VideoHub](http://i.imgur.com/4Rcmqxn.png)
Video sharing webservice.

## Current status
[![Build Status](https://travis-ci.org/maciaszczykm/videohub.svg?branch=master)](https://travis-ci.org/maciaszczykm/videohub)

## Workspace setup
1. Checkout project from GitHub.
2. Update Bower dependencies.
3. Import Maven project into your IDE.
4. To configure JRebel add `videohub.basedir` property to your JVM options. It should point at VideoHub base directory.
For example `-Dvideohub.basedir=D:\Workspace\VideoHub`.
5. Proceed to server setup.

## Server setup
1. Download and install newest version of WildFly server from http://wildfly.org/.
2. Configure server in your IDE as JBoss server. It's important to name artifact, which will be deployed `ROOT.war`.
You should use exploded artifact to override WildFly default welcome content. You should also verify if 
`<wildfly_home>/standalone/configuration/standalone.xml` does contain valid deployments configuration.
3. Proceed to database setup.

## Database setup
1. Download and install latest version of MongoDB from https://www.mongodb.org/.
2. Create new directory, which will be used as database location. For example `D:\Workspace\Databases\VideoHub`.
3. Go into `VideoHub\database` directory and create copy of `db.cfg.sample` file named `db.cfg`. Update `system.dbPath`
property with reference to directory used in previous step. For example `storage.dbPath: D:\Workspace\Databases\VideoHub`.
4. To register MongoDB as a service starting with your system use following command in console with administrator access
`sc.exe create MongoDB binPath= "\"<mongodb_install_dir>\bin\mongod.exe\" --service --config=\"<videohub_base_dir>\database\db.cfg\"
" DisplayName= "MongoDB" start= "auto"`. Remember to replace `<mongodb_install_dir>` and `<videohub_base_dir>` with 
correct values. For example `sc.exe create MongoDB binPath= "\"C:\PROGRA~1\MongoDB\Server\3.0\bin\mongod.exe\" 
--service --config=\"D:\Workspace\VideoHub\database\db.cfg\"" DisplayName= "MongoDB" start= "auto"`. To start service 
for first time you can just use command `net start MongoDB`.
5. You may also want to use MongoDB client. We recommend Robomongo to you, which you can download from 
http://robomongo.org/.
