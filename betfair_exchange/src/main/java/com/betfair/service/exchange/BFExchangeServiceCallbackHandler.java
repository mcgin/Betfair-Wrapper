
/**
 * BFExchangeServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4  Built on : Apr 26, 2008 (06:24:30 EDT)
 */

    package com.betfair.service.exchange;

    /**
     *  BFExchangeServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class BFExchangeServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public BFExchangeServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public BFExchangeServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getInPlayMarkets method
            * override this method for handling normal response from getInPlayMarkets operation
            */
           public void receiveResultgetInPlayMarkets(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetInPlayMarketsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getInPlayMarkets operation
           */
            public void receiveErrorgetInPlayMarkets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBetLite method
            * override this method for handling normal response from getBetLite operation
            */
           public void receiveResultgetBetLite(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetBetLiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBetLite operation
           */
            public void receiveErrorgetBetLite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketPrices method
            * override this method for handling normal response from getMarketPrices operation
            */
           public void receiveResultgetMarketPrices(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketPricesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketPrices operation
           */
            public void receiveErrorgetMarketPrices(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelBetsByMarket method
            * override this method for handling normal response from cancelBetsByMarket operation
            */
           public void receiveResultcancelBetsByMarket(
                    com.betfair.service.exchange.BFExchangeServiceStub.CancelBetsByMarketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelBetsByMarket operation
           */
            public void receiveErrorcancelBetsByMarket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountStatement method
            * override this method for handling normal response from getAccountStatement operation
            */
           public void receiveResultgetAccountStatement(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetAccountStatementResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountStatement operation
           */
            public void receiveErrorgetAccountStatement(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarket method
            * override this method for handling normal response from getMarket operation
            */
           public void receiveResultgetMarket(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarket operation
           */
            public void receiveErrorgetMarket(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketPricesCompressed method
            * override this method for handling normal response from getMarketPricesCompressed operation
            */
           public void receiveResultgetMarketPricesCompressed(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketPricesCompressedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketPricesCompressed operation
           */
            public void receiveErrorgetMarketPricesCompressed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBetHistory method
            * override this method for handling normal response from getBetHistory operation
            */
           public void receiveResultgetBetHistory(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetBetHistoryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBetHistory operation
           */
            public void receiveErrorgetBetHistory(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCompleteMarketPricesCompressed method
            * override this method for handling normal response from getCompleteMarketPricesCompressed operation
            */
           public void receiveResultgetCompleteMarketPricesCompressed(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetCompleteMarketPricesCompressedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCompleteMarketPricesCompressed operation
           */
            public void receiveErrorgetCompleteMarketPricesCompressed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketInfo method
            * override this method for handling normal response from getMarketInfo operation
            */
           public void receiveResultgetMarketInfo(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketInfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketInfo operation
           */
            public void receiveErrorgetMarketInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateBets method
            * override this method for handling normal response from updateBets operation
            */
           public void receiveResultupdateBets(
                    com.betfair.service.exchange.BFExchangeServiceStub.UpdateBetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateBets operation
           */
            public void receiveErrorupdateBets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketProfitAndLoss method
            * override this method for handling normal response from getMarketProfitAndLoss operation
            */
           public void receiveResultgetMarketProfitAndLoss(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketProfitAndLossResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketProfitAndLoss operation
           */
            public void receiveErrorgetMarketProfitAndLoss(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelBets method
            * override this method for handling normal response from cancelBets operation
            */
           public void receiveResultcancelBets(
                    com.betfair.service.exchange.BFExchangeServiceStub.CancelBetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelBets operation
           */
            public void receiveErrorcancelBets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllMarkets method
            * override this method for handling normal response from getAllMarkets operation
            */
           public void receiveResultgetAllMarkets(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetAllMarketsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllMarkets operation
           */
            public void receiveErrorgetAllMarkets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPrivateMarkets method
            * override this method for handling normal response from getPrivateMarkets operation
            */
           public void receiveResultgetPrivateMarkets(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetPrivateMarketsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPrivateMarkets operation
           */
            public void receiveErrorgetPrivateMarkets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentBets method
            * override this method for handling normal response from getCurrentBets operation
            */
           public void receiveResultgetCurrentBets(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetCurrentBetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentBets operation
           */
            public void receiveErrorgetCurrentBets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMUBetsLite method
            * override this method for handling normal response from getMUBetsLite operation
            */
           public void receiveResultgetMUBetsLite(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMUBetsLiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMUBetsLite operation
           */
            public void receiveErrorgetMUBetsLite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketTradedVolumeCompressed method
            * override this method for handling normal response from getMarketTradedVolumeCompressed operation
            */
           public void receiveResultgetMarketTradedVolumeCompressed(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketTradedVolumeCompressedResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketTradedVolumeCompressed operation
           */
            public void receiveErrorgetMarketTradedVolumeCompressed(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMUBets method
            * override this method for handling normal response from getMUBets operation
            */
           public void receiveResultgetMUBets(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMUBetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMUBets operation
           */
            public void receiveErrorgetMUBets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBetMatchesLite method
            * override this method for handling normal response from getBetMatchesLite operation
            */
           public void receiveResultgetBetMatchesLite(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetBetMatchesLiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBetMatchesLite operation
           */
            public void receiveErrorgetBetMatchesLite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCurrentBetsLite method
            * override this method for handling normal response from getCurrentBetsLite operation
            */
           public void receiveResultgetCurrentBetsLite(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetCurrentBetsLiteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCurrentBetsLite operation
           */
            public void receiveErrorgetCurrentBetsLite(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getSilks method
            * override this method for handling normal response from getSilks operation
            */
           public void receiveResultgetSilks(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetSilksResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getSilks operation
           */
            public void receiveErrorgetSilks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for heartbeat method
            * override this method for handling normal response from heartbeat operation
            */
           public void receiveResultheartbeat(
                    com.betfair.service.exchange.BFExchangeServiceStub.HeartbeatResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from heartbeat operation
           */
            public void receiveErrorheartbeat(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getMarketTradedVolume method
            * override this method for handling normal response from getMarketTradedVolume operation
            */
           public void receiveResultgetMarketTradedVolume(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetMarketTradedVolumeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getMarketTradedVolume operation
           */
            public void receiveErrorgetMarketTradedVolume(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCoupon method
            * override this method for handling normal response from getCoupon operation
            */
           public void receiveResultgetCoupon(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetCouponResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCoupon operation
           */
            public void receiveErrorgetCoupon(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for placeBets method
            * override this method for handling normal response from placeBets operation
            */
           public void receiveResultplaceBets(
                    com.betfair.service.exchange.BFExchangeServiceStub.PlaceBetsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from placeBets operation
           */
            public void receiveErrorplaceBets(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getBet method
            * override this method for handling normal response from getBet operation
            */
           public void receiveResultgetBet(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetBetResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getBet operation
           */
            public void receiveErrorgetBet(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAccountFunds method
            * override this method for handling normal response from getAccountFunds operation
            */
           public void receiveResultgetAccountFunds(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetAccountFundsResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAccountFunds operation
           */
            public void receiveErrorgetAccountFunds(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getDetailAvailableMktDepth method
            * override this method for handling normal response from getDetailAvailableMktDepth operation
            */
           public void receiveResultgetDetailAvailableMktDepth(
                    com.betfair.service.exchange.BFExchangeServiceStub.GetDetailAvailableMktDepthResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getDetailAvailableMktDepth operation
           */
            public void receiveErrorgetDetailAvailableMktDepth(java.lang.Exception e) {
            }
                


    }
    