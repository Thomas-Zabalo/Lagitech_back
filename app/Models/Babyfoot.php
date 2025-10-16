<?php

/**
 * Created by Reliese Model.
 */

namespace App\Models;

use Illuminate\Database\Eloquent\Collection;
use Illuminate\Database\Eloquent\Model;

/**
 * Class Babyfoot
 *
 * @property int $id
 * @property bool|null $is_used
 * @property string|null $etat
 *
 * @property Collection|Match[] $matches
 *
 * @package App\Models
 */
class Babyfoot extends Model
{
	protected $table = 'babyfoot';
	public $timestamps = false;

	protected $casts = [
		'is_used' => 'bool'
	];

	protected $fillable = [
		'is_used',
		'etat'
	];

	public function matches()
	{
		return $this->hasMany(Matches::class);
	}
}
