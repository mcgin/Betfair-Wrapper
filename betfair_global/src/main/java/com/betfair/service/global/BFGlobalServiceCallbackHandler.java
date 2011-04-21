
/**
 * BFGlobalServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package com.betfair.service.global;

    /**
     *  BFGlobalServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BFGlobalServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BFGlobalServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BFGlobalServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for viewReferAndEarn method
            * override this method for handling normal response from viewReferAndEarn operation
            */
           public void receiveResultviewReferAndEarn(
                    com.betfair.service.global.BFGlobalServiceStub.ViewReferAndEarnResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from viewReferAndEarn operation
           */
            public void receiveErrorviewReferAndEarn(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPaymentCard method
            * override this method for handling normal response from getPaymentCard operation
            */
           public void receiveResultgetPaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.GetPaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPaymentCard operation
           */
            public void receiveErrorgetPaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logout method
            * override this method for handling normal response from logout operation
            */
           public void receiveResultlogout(
                    com.betfair.service.global.BFGlobalServiceStub.LogoutResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logout operation
           */
            public void receiveErrorlogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveLIMBMessage method
            * override this method for handling normal response from retrieveLIMBMessage operation
            */
           public void receiveResultretrieveLIMBMessage(
                    com.betfair.service.global.BFGlobalServiceStub.RetrieveLIMBMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveLIMBMessage operation
           */
            public void receiveErrorretrieveLIMBMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for login method
            * override this method for handling normal response from login operation
            */
           public void receiveResultlogin(
                    com.betfair.service.global.BFGlobalServiceStub.LoginResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from login operation
           */
            public void receiveErrorlogin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updatePaymentCard method
            * override this method for handling normal response from updatePaymentCard operation
            */
           public void receiveResultupdatePaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.UpdatePaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updatePaymentCard operation
           */
            public void receiveErrorupdatePaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for selfExclude method
            * override this method for handling normal response from selfExclude operation
            */
           public void receiveResultselfExclude(
                    com.betfair.service.global.BFGlobalServiceStub.SelfExcludeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from selfExclude operation
           */
            public void receiveErrorselfExclude(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllEventTypes method
            * override this method for handling normal response from getAllEventTypes operation
            */
           public void receiveResultgetAllEventTypes(
                    com.betfair.service.global.BFGlobalServiceStub.GetAllEventTypesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllEventTypes operation
           */
            public void receiveErrorgetAllEventTypes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for transferFunds method
            * override this method for handling normal response from transferFunds operation
            */
           public void receiveResulttransferFunds(
                    com.betfair.service.global.BFGlobalServiceStub.TransferFundsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from transferFunds operation
           */
            public void receiveErrortransferFunds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addPaymentCard method
            * override this method for handling normal response from addPaymentCard operation
            */
           public void receiveResultaddPaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.AddPaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addPaymentCard operation
           */
            public void receiveErroraddPaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getActiveEventTypes method
            * override this method for handling normal response from getActiveEventTypes operation
            */
           public void receiveResultgetActiveEventTypes(
                    com.betfair.service.global.BFGlobalServiceStub.GetActiveEventTypesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getActiveEventTypes operation
           */
            public void receiveErrorgetActiveEventTypes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for convertCurrency method
            * override this method for handling normal response from convertCurrency operation
            */
           public void receiveResultconvertCurrency(
                    com.betfair.service.global.BFGlobalServiceStub.ConvertCurrencyResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from convertCurrency operation
           */
            public void receiveErrorconvertCurrency(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for submitLIMBMessage method
            * override this method for handling normal response from submitLIMBMessage operation
            */
           public void receiveResultsubmitLIMBMessage(
                    com.betfair.service.global.BFGlobalServiceStub.SubmitLIMBMessageResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from submitLIMBMessage operation
           */
            public void receiveErrorsubmitLIMBMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyProfile method
            * override this method for handling normal response from modifyProfile operation
            */
           public void receiveResultmodifyProfile(
                    com.betfair.service.global.BFGlobalServiceStub.ModifyProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyProfile operation
           */
            public void receiveErrormodifyProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for depositFromPaymentCard method
            * override this method for handling normal response from depositFromPaymentCard operation
            */
           public void receiveResultdepositFromPaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.DepositFromPaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from depositFromPaymentCard operation
           */
            public void receiveErrordepositFromPaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for viewProfile method
            * override this method for handling normal response from viewProfile operation
            */
           public void receiveResultviewProfile(
                    com.betfair.service.global.BFGlobalServiceStub.ViewProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from viewProfile operation
           */
            public void receiveErrorviewProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyPassword method
            * override this method for handling normal response from modifyPassword operation
            */
           public void receiveResultmodifyPassword(
                    com.betfair.service.global.BFGlobalServiceStub.ModifyPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyPassword operation
           */
            public void receiveErrormodifyPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for keepAlive method
            * override this method for handling normal response from keepAlive operation
            */
           public void receiveResultkeepAlive(
                    com.betfair.service.global.BFGlobalServiceStub.KeepAliveResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from keepAlive operation
           */
            public void receiveErrorkeepAlive(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSubscriptionInfo method
            * override this method for handling normal response from getSubscriptionInfo operation
            */
           public void receiveResultgetSubscriptionInfo(
                    com.betfair.service.global.BFGlobalServiceStub.GetSubscriptionInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSubscriptionInfo operation
           */
            public void receiveErrorgetSubscriptionInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEvents method
            * override this method for handling normal response from getEvents operation
            */
           public void receiveResultgetEvents(
                    com.betfair.service.global.BFGlobalServiceStub.GetEventsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEvents operation
           */
            public void receiveErrorgetEvents(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for forgotPassword method
            * override this method for handling normal response from forgotPassword operation
            */
           public void receiveResultforgotPassword(
                    com.betfair.service.global.BFGlobalServiceStub.ForgotPasswordResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from forgotPassword operation
           */
            public void receiveErrorforgotPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for withdrawToPaymentCard method
            * override this method for handling normal response from withdrawToPaymentCard operation
            */
           public void receiveResultwithdrawToPaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.WithdrawToPaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from withdrawToPaymentCard operation
           */
            public void receiveErrorwithdrawToPaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deletePaymentCard method
            * override this method for handling normal response from deletePaymentCard operation
            */
           public void receiveResultdeletePaymentCard(
                    com.betfair.service.global.BFGlobalServiceStub.DeletePaymentCardResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deletePaymentCard operation
           */
            public void receiveErrordeletePaymentCard(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createAccount method
            * override this method for handling normal response from createAccount operation
            */
           public void receiveResultcreateAccount(
                    com.betfair.service.global.BFGlobalServiceStub.CreateAccountResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createAccount operation
           */
            public void receiveErrorcreateAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllCurrencies method
            * override this method for handling normal response from getAllCurrencies operation
            */
           public void receiveResultgetAllCurrencies(
                    com.betfair.service.global.BFGlobalServiceStub.GetAllCurrenciesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllCurrencies operation
           */
            public void receiveErrorgetAllCurrencies(java.lang.Exception e) {
            }
                


    }
    