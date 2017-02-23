#!/bin/bash

rm com/ss/domain/*.class
rm com/ss/base/*.class


javac com/ss/domain/TravelExpenseFactory.java

jar cvf com/ss/base/BaseEntity.jar com/ss/base/BaseEntity.class
jar cvf com/ss/domain/AppMenu.jar com/ss/domain/AppMenu.class
jar cvf com/ss/domain/AppRole.jar com/ss/domain/AppRole.class
jar cvf com/ss/domain/AppRoleMenu.jar com/ss/domain/AppRoleMenu.class
jar cvf com/ss/domain/AppUser.jar com/ss/domain/AppUser.class
jar cvf com/ss/domain/AppUserRole.jar com/ss/domain/AppUserRole.class
jar cvf com/ss/domain/ApproveMapFlow.jar com/ss/domain/ApproveMapFlow.class
jar cvf com/ss/domain/Bank.jar com/ss/domain/Bank.class
jar cvf com/ss/domain/Company.jar com/ss/domain/Company.class
jar cvf com/ss/domain/Customer.jar com/ss/domain/Customer.class
jar cvf com/ss/domain/Department.jar com/ss/domain/Department.class
jar cvf com/ss/domain/DocumentApprove.jar com/ss/domain/DocumentApprove.class
jar cvf com/ss/domain/DocumentMaster.jar com/ss/domain/DocumentMaster.class
jar cvf com/ss/domain/TravelExpense.jar com/ss/domain/TravelExpense.class
jar cvf com/ss/domain/TravelExpenseDetail.jar com/ss/domain/TravelExpenseDetail.class
jar cvf com/ss/domain/TravelExpenseFactory.jar com/ss/domain/TravelExpenseFactory.class
