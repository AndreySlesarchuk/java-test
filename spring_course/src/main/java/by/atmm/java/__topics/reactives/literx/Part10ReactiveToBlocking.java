package by.atmm.java.__topics.reactives.literx;

import by.atmm.java.__topics.reactives.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to turn Reactive API to blocking one.
 *
 * @author Sebastien Deleuze
 */
public class Part10ReactiveToBlocking {

//========================================================================================

	// TODO Return the user contained in that Mono
	User monoToValue(Mono<User> mono) {
		return null;
	}

//========================================================================================

	// TODO Return the users contained in that Flux
	Iterable<User> fluxToValues(Flux<User> flux) {
		return null;
	}

}
