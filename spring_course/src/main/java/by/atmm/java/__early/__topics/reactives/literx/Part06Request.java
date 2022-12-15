package by.atmm.java.__early.__topics.reactives.literx;

import by.atmm.java.__early.__topics.reactives.literx.domain.User;
import by.atmm.java.__early.__topics.reactives.literx.repository.ReactiveRepository;
import by.atmm.java.__early.__topics.reactives.literx.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;


/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part06Request {

	ReactiveRepository<User> repository = new ReactiveUserRepository();

//========================================================================================

	// TODO Create a StepVerifier that initially requests all values and expect 4 values to be received
	/*StepVerifier requestAllExpectFour(Flux<User> flux) {
		return null;
	}*/

//========================================================================================

	// TODO Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE then stops verifying by cancelling the source
	/* pVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
		return null;
	}
*/
//========================================================================================

	// TODO Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
	Flux<User> fluxWithLog() {
		return null;
	}

//========================================================================================

	// TODO Return a Flux with all users stored in the repository that prints "Starring:" on subscribe, "firstname lastname" for all values and "The end!" on complete
	Flux<User> fluxWithDoOnPrintln() {
		return null;
	}

}
