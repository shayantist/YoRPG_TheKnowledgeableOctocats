/**
 * The Knowledgeable Octocats - Oliver Frank, Shayan Chowdhury, Kevin Feng
 * APCS pd02
 * HW28 -- Ye Olde Role Playing Game, Expanded
 * 2017-11-13
 **/

/**
 * A Protagonist that can fight Monsters. Has attributes like:
 * <ul>
 * 	<li>_name</li>
 *  <li>_hitPts</li>
 * 	<li>_strength</li>
 * 	<li>_defense</li>
 * 	<li>_attack</li>
 * </ul>
 * It can only attack currently. It has two attacks, normal and special.
 * The user is able to control this character. This class inherits properties from
 * the Entity class.
 * @author Oliver Frank
 */

public class Protagonist extends Character
{
  // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
  protected String _name = "J. Doe";
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /*=============================================
    default constructor
    pre:  instance vars are declared
    post: initializes instance vars.
    =============================================*/
  public Protagonist()
  {
    _hitPts = 125;
    _strength = 100;
    _defense = 40;
    _attack = .4;
  }


  /*=============================================
    overloaded constructor
    pre:  instance vars are declared
    post: initializes instance vars. _name is set to input String.
    =============================================*/
  public Protagonist( String name ) {
    this();
    _name = name;
  }


  // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
  public String getName() { return _name; }
  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  /*=============================================
    int attack(Monster) -- simulates attack on instance of class Monster
    pre:  Input not null
    post: Calculates damage to be inflicted, flooring at 0. 
    Calls opponent's lowerHP() method to inflict damage. 
    Returns damage dealt.
    =============================================*/
  public int attack( Monster opponent )
  {

    int damage = (int)( (_strength * _attack) - opponent.getDefense() );
    //System.out.println( "\t\t**DIAG** damage: " + damage );

    if ( damage < 0 )
	    damage = 0;

    opponent.lowerHP( damage );

    return damage;
  }//end attack


  //prepare a Protagonist for a special attack
  public void specialize()
  {
    _attack = .75;
    _defense = 20;
  }


  //revert to normal mode
  public void normalize()
  {
    _attack = .4;
    _defense = 40;
  }

}//end class Protagonist