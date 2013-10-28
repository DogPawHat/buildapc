buildapc
========

Software Architecture team project done in October-November 2012


The objective of this project was to learn more about Software Design, in parturuler the design patterns for reusable code advocted by Gamma et al in "Design Patterns: Elements of Reusable Object-Oriented Software". Myself and two others (Eoin Joy and William Laffen) created and documeneded code and JUnit test cases for a simple system prototype that allowed a user to create a new PC from a list of components.

The structure of the Repo is a follows:

root: contains the marking schmeme and the report the team submitted on the project.
Source Files: contains the JUnit test cases and the BuildAPC Java package
Source Files/BuildAPC: contains the implemntation code for the project as a Java package

Aside from my input into the report, the files that were directly written my me are:
Source Files/BuildAPC/: IObserver.java, IObservable.java, Order.java, OrderCancled.java, OrderShipped.java, OrderTracker.java, State.java, Processing.java, PCBuilt.java, PCBuilding.java, PCSelected.java

Everything else is copyright Eoin Joy or William Laffen.
