<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Collection;
use Illuminate\Database\Eloquent\Model;

/**
 * Class Team
 *
 * @property int $id
 * @property string $nom
 *
 * @property Collection|Goal[] $goals
 * @property Collection|Match[] $matches
 * @property Collection|User[] $users
 *
 * @package App\Models
 */
class Team extends Model
{
	protected $table = 'team';
	public $timestamps = false;

	protected $fillable = [
		'nom'
	];

	public function goals()
	{
		return $this->hasMany(Goal::class, 'id_equipe');
	}

	public function matches()
	{
        		return $this->hasMany(Matches::class, 'id_equipe_2');
	}

	public function users()
	{
		return $this->hasMany(User::class);
	}
}
