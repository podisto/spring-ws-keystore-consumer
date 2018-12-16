package sn.sonatel.dsi.dif.springwskeystoreconsumer.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import sn.sonatel.dsi.dif.springwskeystoreconsumer.wsdl.GetTeamRequest;
import sn.sonatel.dsi.dif.springwskeystoreconsumer.wsdl.GetTeamResponse;

/**
 * @author podisto
 * @since
 */
public class TeamClient extends WebServiceGatewaySupport {
    public GetTeamResponse getTeamByCountryCode(String countryCode) {
        GetTeamRequest request = new GetTeamRequest();
        request.setCountryCode(countryCode);

        return (GetTeamResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
