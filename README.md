This repository is to reproduce a issue related to ZIO ZEnvironment.

```shell
➜  zio-problem-producer git:(main) ✗ sbt run
[info] welcome to sbt 1.9.8 (N/A Java 17.0.13)
[info] loading global plugins from /home/kimmo/.sbt/1.0/plugins
[info] loading settings for project zio-problem-producer-build-build from metals.sbt ...
[info] loading project definition from /home/kimmo/dev/ke/zio-problem-producer/project/project
[info] loading settings for project zio-problem-producer-build from metals.sbt ...
[info] loading project definition from /home/kimmo/dev/ke/zio-problem-producer/project
[success] Generated .bloop/zio-problem-producer-build.json
[success] Total time: 1 s, completed Jan 9, 2025, 4:10:50 PM
[info] loading settings for project root from build.sbt ...
[info] set current project to zio-problem-producer (in build file:/home/kimmo/dev/ke/zio-problem-producer/)
[info] running Main 
timestamp=2025-01-09T14:10:52.472125616Z level=INFO thread=#zio-fiber-1656808883 message="Starting the server..." location=<empty>.Main.run file=Main.scala line=25
timestamp=2025-01-09T14:10:54.611416651Z level=ERROR thread=#zio-fiber-1001889405 message="" cause="Exception in thread "zio-fiber-1656808883" java.lang.Error: Defect in zio.ZEnvironment: HashSet(Map[=String,+{_$One & _$Two}]) statically known to be contained within the environment are missing
        at zio.ZEnvironment.prune(ZEnvironment.scala:183)
        at zio.http.Server$ServerLive.install$$anonfun$3$$anonfun$1$$anonfun$1(Server.scala:533)
        at <empty>.Main.run(Main.scala:25)"
[error] Exception in thread "zio-fiber-1656808883" java.lang.Error: Defect in zio.ZEnvironment: HashSet(Map[=String,+{_$One & _$Two}]) statically known to be contained within the environment are missing
[error]         at zio.ZEnvironment.prune(ZEnvironment.scala:183)
[error]         at zio.http.Server$ServerLive.install$$anonfun$3$$anonfun$1$$anonfun$1(Server.scala:533)
[error]         at <empty>.Main.run(Main.scala:25)
[error]         at zio.ZEnvironment.prune(ZEnvironment.scala:183)
[error]         at zio.http.Server$ServerLive.install$$anonfun$3$$anonfun$1$$anonfun$1(Server.scala:533)
[error]         at <empty>.Main.run(Main.scala:25)
[error] Caused by: java.lang.Error: Defect in zio.ZEnvironment: HashSet(Map[=String,+{_$One & _$Two}]) statically known to be contained within the environment are missing
[error]         at zio.ZEnvironment.prune(ZEnvironment.scala:183)
[error]         at zio.http.Server$ServerLive.install$$anonfun$3$$anonfun$1$$anonfun$1(Server.scala:533)
[error]         at zio.internal.FiberRuntime.runLoop(FiberRuntime.scala:1072)
[error]         at zio.internal.FiberRuntime.runLoop(FiberRuntime.scala:1063)
[error]         at zio.internal.FiberRuntime.evaluateEffect(FiberRuntime.scala:412)
[error]         at zio.internal.FiberRuntime.evaluateMessageWhileSuspended(FiberRuntime.scala:488)
[error]         at zio.internal.FiberRuntime.drainQueueOnCurrentThread(FiberRuntime.scala:249)
[error]         at zio.internal.FiberRuntime.run(FiberRuntime.scala:137)
[error]         at zio.internal.ZScheduler$$anon$3.run(ZScheduler.scala:380)
[error] stack trace is suppressed; run last Compile / run for the full output
[error] (Compile / run) Exception in thread "zio-fiber-1656808883" java.lang.Error: Defect in zio.ZEnvironment: HashSet(Map[=String,+{_$One & _$Two}]) statically known to be contained within the environment are missing
[error]         at zio.ZEnvironment.prune(ZEnvironment.scala:183)
[error]         at zio.http.Server$ServerLive.install$$anonfun$3$$anonfun$1$$anonfun$1(Server.scala:533)
[error]         at <empty>.Main.run(Main.scala:25)
[error] Total time: 3 s, completed Jan 9, 2025, 4:10:54 PM

```
