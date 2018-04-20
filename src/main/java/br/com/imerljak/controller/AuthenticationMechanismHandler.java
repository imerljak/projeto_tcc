package br.com.imerljak.controller;

//@AutoApplySession
//@RequestScoped
public class AuthenticationMechanismHandler
//        implements HttpAuthenticationMechanism
{

//    @Inject
//    private IdentityStore identityStore;

//    @Override
//    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
//        String name = request.getParameter("name");
//        if (name != null && request.getParameter("password") != null) {
//
//            Password password = new Password(request.getParameter("password"));
//
//            CredentialValidationResult result = identityStore.validate(new UsernamePasswordCredential(name, password));
//
//            if (result.getStatus() == VALID) {
//                return httpMessageContext.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
//            } else {
//                return httpMessageContext.responseUnauthorized();
//            }
//        }
//
//        return httpMessageContext.doNothing();
//    }

}
